package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.enums.UserEnum;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User addUser(User user) throws UserException {
        if (userDao.isExisted(user)) {
            throw new UserException(UserEnum.DUPLICATE_USER_NAME);
        }
        return userDao.addUser(user);
    }

    public User fineById(Integer id) {
        return userDao.selectUserById(id);
    }

    public List<User> list(Integer pageNum, Integer pageSzie) {
        return userDao.list(pageNum, pageSzie);
    }

    public boolean isExsited(User user) {
        return userDao.isExisted(user);
    }

    public Integer count() {
        return userDao.count();
    }
}