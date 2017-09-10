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
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", required = true, value = "用户的密码", dataType = "User")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @PostMapping(value = "/")
    public User addUser(@RequestBody User user) throws UserException {
        return userService.addUser(user);
    }

    @ApiOperation("根据ID查询用户信息")
    @ApiImplicitParam(paramType = "path", name = "id", dataType = "Long", required = true, value = "用户ID")
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") Integer id) {
        logger.debug("id:" + id);
        return userService.fineById(id);
    }

    @ApiOperation(value = "获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "pageNum", dataType = "Long", value = "页码", defaultValue = "1"),
            @ApiImplicitParam(paramType = "path", name = "pageSize", dataType = "Long", value = "每页大小", defaultValue = "10")
    })
    @GetMapping("/list/{pageNum}/{pageSize}")
    public List<User> list(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        return userService.list(pageNum, pageSize);
    }
}