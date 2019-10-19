package com.kayleoi.springbootcommunity.controller;

import com.kayleoi.springbootcommunity.dto.CommentDTO;
import com.kayleoi.springbootcommunity.dto.QuestionDTO;
import com.kayleoi.springbootcommunity.enums.CommentTypeEnum;
import com.kayleoi.springbootcommunity.exception.CustomizeErrorCode;
import com.kayleoi.springbootcommunity.exception.CustomizeException;
import com.kayleoi.springbootcommunity.service.CommentService;
import com.kayleoi.springbootcommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/10/15
 */
@Controller
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @Autowired
    CommentService commentService;

    @RequestMapping("/question/{id}")
    public String getById(@PathVariable(name = "id") String id, Model model) {
        Long questionId = null;
        try {
            questionId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        }
        QuestionDTO questionDTO = questionService.getById(questionId);
        List <QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
        List <CommentDTO> comments = commentService.listByTargetId(questionId, CommentTypeEnum.QUESTION);
        //累加阅读数
        questionService.incView(questionId);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }
}
