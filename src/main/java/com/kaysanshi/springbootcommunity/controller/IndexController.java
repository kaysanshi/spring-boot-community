package com.kaysanshi.springbootcommunity.controller;

import com.kaysanshi.springbootcommunity.cache.HotTagCache;
import com.kaysanshi.springbootcommunity.dao.UserMapper;
import com.kaysanshi.springbootcommunity.dto.PaginationDTO;
import com.kaysanshi.springbootcommunity.model.User;
import com.kaysanshi.springbootcommunity.model.UserExample;
import com.kaysanshi.springbootcommunity.service.NotificationService;
import com.kaysanshi.springbootcommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author kay三石
 * @date:2019/10/6
 */
@Controller
public class IndexController {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @Autowired
    private HotTagCache hotTagCache;

    /**
     * 校验token
     * 小用户量的可以用这个
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "10") Integer size,
                        @RequestParam(name = "search", required = false) String search,
                        @RequestParam(name = "tag", required = false) String tag,
                        @RequestParam(name = "sort", required = false) String sort,
                        HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                System.out.println("token:" + token);
                User user = userMapper.findByToken(token);
                System.out.println(user);
                if (user != null) {
                    //登录成功 保存session
                    UserExample userExample = new UserExample();
                    userExample.createCriteria()
                            .andTokenEqualTo(token);
                    List <User> users = userMapper.selectByExample(userExample);
                    if (users.size() != 0) {
                        HttpSession session = request.getSession();
                        session.setAttribute("user", users.get(0));
                        Long unreadCount = notificationService.unreadCount(users.get(0).getId());
                        session.setAttribute("unreadCount", unreadCount);
                    }
                    request.getSession().setAttribute("user", user); // 把用户保存到session中
                    System.out.println("ssssss:" + request.getSession().getAttribute("user"));

                } else {
                    request.getSession().setAttribute("user", user); // 把用户保存到session中
                    System.out.println("sss" + request.getSession().getAttribute("user"));

                }
                break;
            }
        }
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

    @RequestMapping("/index")
    public String toIndex(Model model,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "10") Integer size,
                          @RequestParam(name = "search", required = false) String search,
                          @RequestParam(name = "tag", required = false) String tag,
                          @RequestParam(name = "sort", required = false) String sort,
                          HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        System.out.println("to index");
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if (user != null) {
                    //登录成功 保存session
                    request.getSession().setAttribute("user", user); // 把用户保存到session中
                    System.out.println(request.getSession().getAttribute("user"));
                } else {
                    request.getSession().setAttribute("user", user); // 把用户保存到session中
                    System.out.println("失败" + request.getSession().getAttribute("user"));

                }
                break;
            }
        }
        PaginationDTO pagination = questionService.list(search, tag, sort, page, size);
        List <String> tags = hotTagCache.getHots();
        model.addAttribute("pagination", pagination);
        model.addAttribute("search", search);
        model.addAttribute("tag", tag);
        model.addAttribute("tags", tags);
        model.addAttribute("sort", sort);
        return "index";
    }

}
