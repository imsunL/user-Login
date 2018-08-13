package com.xyz.user.Dao;


import com.xyz.user.User.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface UserDao {
    @Select("select * from user where user_name = #{userName} limit 1")
    User getUser(String userName);

    @Insert("insert into user (user_name,password) values (#{userName},#{password}")
    boolean insert(User user);
}
