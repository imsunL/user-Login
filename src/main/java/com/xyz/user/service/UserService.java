package com.xyz.user.service;

import com.xyz.user.mapper.UserMapper;
import com.xyz.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //注册
    public String register(User user) throws Exception {
        if (userMapper.selectUser(user.getUsername()) == null) {
            userMapper.insertUser(user);
            return "注册成功";

        } else {
            return "用户名已存在";
        }
    }

    //登录
    public String login(User user) throws Exception {
        if (userMapper.selectUser(user.getUsername()) != null) {
            if (userMapper.selectUser(user.getPassword()).equals(user.getPassword())) {
                return "登录成功";
            }else {
                return "密码不正确";
            }
        }else {
            return "用户名不正确";
        }
    }

}
