package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Insert("INSERT INTO user(username, password) VALUES(#{userName}, #{password})")
    int addUser(@Param("userName") String username, @Param("password") String password);

    /**
     * 插入用户，并将主键设置到user中
     * 注意：返回的是数据库影响条数，即1
     */
    int insertUserWithBackId(User user);

    List<User> queryUserList(Integer pageNum, Integer pageSize);
}
