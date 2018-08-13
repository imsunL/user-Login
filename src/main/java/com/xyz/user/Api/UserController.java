package com.xyz.user.Api;


import com.xyz.user.User.User;
import com.xyz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //重定向到index
    @RequestMapping("")
    public String index(HttpServletResponse response) {
        return response.encodeRedirectURL("/index");
    }

    @RequestMapping("/index")
    public String home(Model model) {
        return "index";
    }


    @PostMapping("/register")
    public String register(Model model, User user,HttpServletResponse response) {
        String result = userService.register(user);
        model.addAttribute("result",result);
        return  response.encodeRedirectURL("/index");
    }

    @PostMapping("/login")
    public String login(Model model ,User user,HttpServletResponse response) {
        String result = userService.login(user);
        model.addAttribute("result",result);
        return  response.encodeRedirectURL("/success");
    }

}
