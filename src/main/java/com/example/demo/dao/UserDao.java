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

    public User addUser(User user) throws BaseException {
        try {
            iUser.add(user);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(500, e.getMessage());
        }

        return user;
    }

    public List<User> list(Integer pageNum, Integer pageSzie) {
        PageHelper.startPage(pageNum, pageSzie);
        return iUser.list();
    }

    public Integer count() {
        return iUser.count();
    }

    public Boolean isExisted(User user) {
        return iUser.isExisted(user) != null;
    }

    public Integer update(Integer id, User user) {
        return iUser.update(id, user);
    }

    public Integer delete(Integer id) {
        return iUser.delete(id);
    }

    public User findByName(String name) {
        return iUser.findByName(name);
    }
}
