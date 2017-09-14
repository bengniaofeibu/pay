package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUser {
    Integer add(User user);
    User update(Integer id,User user);
    User delete(Integer id);
    List<User> list();
    User findById(Integer id);
    User findByName(String userName);
    User isExisted(User user);
    Integer count();
}
