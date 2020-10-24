package com.kaysanshi.springbootcommunity.controller;

import com.kaysanshi.springbootcommunity.dto.CommentDTO;
import com.kaysanshi.springbootcommunity.dto.QuestionDTO;
import com.kaysanshi.springbootcommunity.enums.CommentTypeEnum;
import com.kaysanshi.springbootcommunity.exception.CustomizeErrorCode;
import com.kaysanshi.springbootcommunity.exception.CustomizeException;
import com.kaysanshi.springbootcommunity.service.CommentService;
import com.kaysanshi.springbootcommunity.service.QuestionService;
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
        model.addAttribute("question_user",questionDTO.getUser());
        return "question";
    }
}
