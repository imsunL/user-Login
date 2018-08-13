package com.xyz.user.service;

import com.xyz.user.Dao.UserDao;
import com.xyz.user.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //注册
    public String register(User user) {
        if (userDao.getUser(user.getUserName()) == null) {
            userDao.insert(user);
            return "注册成功";

        } else {
            return "用户名已存在";
        }
    }

    //登录
    public String login(User user) {
        if (userDao.getUser(user.getUserName()) != null) {
            if (userDao.getUser(user.getPassword()).equals(user.getPassword())) {
                return "登录成功";
            }else {
                return "密码不正确";
            }
        }else {
            return "用户名不正确";
        }
    }
}
