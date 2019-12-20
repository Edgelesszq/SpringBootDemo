package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.domain.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public User getUserByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User getUserByName(String username, String password) {
        return userDao.loginbyPass(username,password);
    }
}
