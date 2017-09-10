package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.*;
import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            @ApiResponse(code = 400, message = "请求参数没填好")
    })
    @PostMapping(value = "/")
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody User user) throws UserException {
        Map<String, Object> map = new HashMap<>();
        User res = userService.addUser(user);
        if (res == null) {
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        map.put("data", res);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @ApiOperation("根据ID查询用户信息")
    @ApiImplicitParam(paramType = "path", name = "id", dataType = "Long", required = true, value = "用户ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Integer id) {
        Map<String, Object> map = new HashMap<>();
        User user = userService.fineById(id);
        if (user == null) {
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        map.put("data", user);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @ApiOperation(value = "获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", dataType = "Long", value = "页码", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Long", value = "每页大小", defaultValue = "10")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "没有找到")
    })
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> list(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize)
            throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("data", userService.list(pageNum, pageSize));
        if (map.get("data") == null) {
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}