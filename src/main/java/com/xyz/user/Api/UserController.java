package com.xyz.user.Api;


import com.xyz.user.model.User;
import com.xyz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
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

    @GetMapping("/register")
    public String register() {return "register";}

    @PostMapping("/register")
    public String register(Model model, User user, HttpServletResponse response, HttpSession session) throws Exception {
        String result = userService.register(user);
        model.addAttribute("result",result);
        return  response.encodeRedirectURL("/index");
    }

    @GetMapping("/login")
    public String login(){return "login";}

    @PostMapping("/login")
    public String login(Model model ,User user,HttpServletResponse response) throws Exception {
        String result = userService.login(user);
        model.addAttribute("result",result);
        return  response.encodeRedirectURL("/success");
    }

}
