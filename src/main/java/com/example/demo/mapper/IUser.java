package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUser {
    Integer addUser(User user);
    List<User> list();
    User findById(Integer id);
    User findByName(String userName);
    User isExisted(User user);
    int count();
}
