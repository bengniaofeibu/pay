package com.example.demo.dao;

import com.example.demo.mapper.IUser;
import com.github.pagehelper.PageHelper;
import com.example.demo.entity.User;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SiteException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    public User addUser(User user) throws SiteException {
        try {
            if (isExisted(user)) {
                throw new SiteException(ResultEnum.DUPLICATE_USER_NAME);
            }
            iUser.addUser(user);
        } catch (SiteException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SiteException(ResultEnum.UNKONW_ERROR);
        }

        return user;
    }

    public List<User> list(Integer pageNum, Integer pageSzie) {
        PageHelper.startPage(pageNum, pageSzie);
        return iUser.list();
    }

    public Integer count() {
        Integer iCount = iUser.count();
        return iCount;
    }

    public Boolean isExisted(User user) {
        logger.debug(user.toString());
        User userRes = iUser.isExisted(user);
        return userRes != null;
    }
}
