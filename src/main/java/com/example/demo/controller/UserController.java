package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.*;
import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api("userController相关api")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = true, value = "用户的姓名", defaultValue = "zhaojigang"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "wangna")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @PostMapping(value = "/")
    public User addUser(@RequestParam("userName") String userName,
                           @RequestParam("password") String password) throws UserException{
        User user = new User(userName, password);
        return userService.addUser(user);
    }

    @ApiOperation("根据ID查询用户信息")
    @ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "用户ID")
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") Integer id) {
        logger.debug("id:" + id);
        return userService.fineById(id);
    }

    @ApiOperation("获取用户列表")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "pageNum", dataType = "String", value = "页码", defaultValue = "1"),
        @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页大小", defaultValue = "10")
    })
    @GetMapping("/list/{pageNum}/{pageSize}")
    public List<User> list(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        return userService.list(pageNum, pageSize);
    }
}