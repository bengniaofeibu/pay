package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUser {
    Integer add(User user);
    List<User> list();
    User findById(Integer id);
    User isExisted(User user);
    Integer count();
    User findByName(String userName);
    Integer update(Integer id,User user);
    Integer delete(Integer id);
}
