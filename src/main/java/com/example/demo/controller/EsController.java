package com.example.demo.controller;

import com.example.demo.model.UserEs;
import com.example.demo.service.EsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("ElasticSearch演示")
@RestController
public class EsController {
    @Autowired
    private EsService esService;

    @ApiOperation(value = "查找一个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, value = "用户id", dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping(value = "/find")
    public Object find(@RequestBody String id) {
        return esService.findUser(id);
    }


}
