package com.kayleoi.springbootcommunity.controller;

import com.kayleoi.springbootcommunity.dao.UserMapper;
import com.kayleoi.springbootcommunity.dto.AccessTokenDTO;
import com.kayleoi.springbootcommunity.dto.GithubUser;
import com.kayleoi.springbootcommunity.model.User;
import com.kayleoi.springbootcommunity.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author kay三石
 * @date:2019/10/6 授权登录信息的操作
 */
@Controller
public class AuthorController {
    @Value("${github.client.id}")
    private String client_id;
    @Value("${github.client.secret}")
    private String client_secret;
    @Value("${github.redirect.url}")
    private String redirect_uri;

    @Autowired
    GithubProvider githubProvider;

    @Autowired
    UserMapper userMapper;

    /**
     * 通过返回的code进行获取验证 然后进行返回到主页
     * 这里需要模拟http
     *
     * @return
     */
    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        AccessTokenDTO dto = new AccessTokenDTO();
        dto.setClient_id(client_id);
        dto.setClient_secret(client_secret);
        dto.setCode(code);
        dto.setState(state);
        dto.setRedirect_uri(redirect_uri);
        String token = githubProvider.getAccessToken(dto); // 获取github中的token
        if (token==null){
            return "redirect:index";
        }
        System.out.println(token);
        GithubUser user = githubProvider.getUser(token); // 通过github中的tokentoken获取用户信息
        if (user != null) {
            User user_model = new User();
            user_model.setName(user.getName());
            user_model.setToken(UUID.randomUUID().toString());
            user_model.setAccount_id(String.valueOf(user.getId()));
            user_model.setGmt_create(System.currentTimeMillis());
            user_model.setGmt_modify(user_model.getGmt_create());
            user_model.setBio(user.getBio());
            user_model.setAvatarUrl(user.getAvatar_url());
            userMapper.insert(user_model);
            request.getSession().setAttribute("user", user);

            Cookie cookie = new Cookie("token", user_model.getToken());// token 设置为数据库中的token
            cookie.setMaxAge(60 * 60 * 24 * 30 * 6);
            response.addCookie(cookie);
            return "redirect:/";
        } else {
            //登录失败
            System.out.println("登录失败：" + user);
            return "redirect:index";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:index";
    }
}
