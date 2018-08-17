package com.xyz.user.mapper;

import com.xyz.user.model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

    int insertUser(User user) throws Exception;

    User selectUser(String username) throws Exception;
}
