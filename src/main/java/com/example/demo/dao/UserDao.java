package com.example.demo.dao;

import com.example.demo.mapper.IUser;
import com.github.pagehelper.PageHelper;
import com.example.demo.entity.User;
import com.example.demo.exception.BaseException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {
    private final SqlSession sqlSession;
    private final Logger logger = LoggerFactory.getLogger(UserDao.class);
    private IUser iUser;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        iUser = this.sqlSession.getMapper(IUser.class);
    }

    public User selectUserById(Integer id) {
        return iUser.findById(id);
    }

    public User addUser(User user) {
        iUser.add(user);
        return user;
    }

    public List<User> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return iUser.list();
    }

    public Integer count() {
        return iUser.count();
    }

    public Boolean isExisted(User user) {
        return iUser.isExisted(user) != null;
    }

    public Integer update(User user) {
        return iUser.update(user);
    }

    public Integer delete(Integer id) {
        return iUser.delete(id);
    }

    public User findByName(String userName) {
        return iUser.findByName(userName);
    }
}
