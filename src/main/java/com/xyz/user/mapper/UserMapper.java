package com.xyz.user.mapper;

import com.xyz.user.model.User;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

public interface UserMapper {

    int insertUser(User user) throws Exception;

    User selectUser(String username) throws Exception;
}
