package com.demo.dao;

import com.demo.domain.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
    User findByName(@Param("username") String username);
    User loginbyPass(@Param("username") String username,@Param("password") String password);

}
