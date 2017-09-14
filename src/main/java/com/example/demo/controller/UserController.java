package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.enums.UserEnum;
import com.example.demo.exception.UserException;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    //    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", required = true, value = "用户的密码", dataType = "User")
    })
    @PostMapping(value = "/")
    public Result addUser(@RequestBody User user) throws Exception {
        User newUser = userService.addUser(user);
        if (newUser == null) {
            throw new UserException(UserEnum.UNKONW_ERROR);
        }

        return ResultUtil.success(newUser);
    }

    @ApiOperation("根据ID查询用户信息")
    @ApiImplicitParam(paramType = "path", name = "id", dataType = "Long", required = true, value = "用户ID")
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable("id") Integer id) throws UserException {
        User user = userService.fineById(id);
        if (user == null) {
            throw new UserException(UserEnum.NOT_FOUND);
        }

        return ResultUtil.success(user);
    }

    @ApiOperation(value = "获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", dataType = "Long", value = "页码", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Long", value = "每页大小", defaultValue = "10")
    })
    @GetMapping("/")
    public Result getUserList(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize)
            throws Exception {
        List<User> userList = userService.list(pageNum, pageSize);
        if (userList.isEmpty()) {
            throw new UserException(UserEnum.NOT_FOUND);
        }

        return ResultUtil.success(userList);
    }

    @ApiOperation(value = "获取用户总个数")
    @GetMapping("/count")
    public ResponseEntity<Map<String, Object>> count() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userCount", userService.count());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @ApiOperation("修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", dataType = "Long", required = true, value = "用户ID"),
            @ApiImplicitParam(paramType = "body", name = "user", required = true, value = "用户信息", dataType = "User")
    })
    @PutMapping(value = "/{id}")
    public Result update(@RequestParam("id") Integer id, @RequestBody User user) throws Exception {
        User oldUser = userService.findByName(user.getUserName());
        if (oldUser == null) {
            if (userService.update(id, user) > 0) {
                return ResultUtil.success();
            } else {
                throw new UserException(UserEnum.UNKONW_ERROR);
            }
        } else {
            throw new UserException(UserEnum.DUPLICATE_USER_NAME);
        }
    }

    @ApiOperation("删除用户")
    @ApiImplicitParam(paramType = "path", name = "id", dataType = "Long", required = true, value = "用户ID")
    @DeleteMapping(value = "/{id}")
    public Result delete(@RequestParam("id") Integer id, @RequestBody User user) throws Exception {
        if (userService.delete(id) > 0) {
            return ResultUtil.success();
        } else {
            throw new UserException(UserEnum.UNKONW_ERROR);
        }
    }
}