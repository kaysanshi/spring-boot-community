package com.kayleoi.springbootcommunity.controller;

import com.kayleoi.springbootcommunity.cache.HotTagCache;
import com.kayleoi.springbootcommunity.dto.PaginationDTO;
import com.kayleoi.springbootcommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author kay三石
 * @date:2019/10/27
 */
@Controller
public class SearchController {
    @Autowired
    QuestionService questionService;

    @Autowired
    private HotTagCache hotTagCache;

    /**
     * 搜索
     *
     * @param model
     * @param page
     * @param size
     * @param search
     * @param tag
     * @param sort
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/search")
    public String search(Model model,
                         @RequestParam(name = "page", defaultValue = "1") Integer page,
                         @RequestParam(name = "size", defaultValue = "10") Integer size,
                         @RequestParam(name = "search", required = false) String search,
                         @RequestParam(name = "tag", required = false) String tag,
                         @RequestParam(name = "sort", required = false) String sort,
                         HttpServletRequest request, HttpServletResponse response) {
        PaginationDTO pagination = questionService.list(search, tag, sort, page, size);
        List <String> tags = hotTagCache.getHots();
        model.addAttribute("pagination", pagination);
        model.addAttribute("search", search);
        model.addAttribute("tag", tag);
        model.addAttribute("tags", tags);
        model.addAttribute("sort", sort);
        System.out.println(pagination.toString());
        System.out.println(model);
        return "index";
    }
}
