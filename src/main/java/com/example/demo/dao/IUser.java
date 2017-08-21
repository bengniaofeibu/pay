package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface IUser {
    Integer addUser(User user);
    List<User> list();
    User findById(Integer id);
    User findByName(String userName);
    User isExisted(User user);
    int count();
}
