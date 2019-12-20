package com.demo.service;

import com.demo.domain.User;

public interface UserService {
    User getUserByName(String name);
    User getUserByName(String username,String password);

}
