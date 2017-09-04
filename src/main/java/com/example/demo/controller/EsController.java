package com.example.demo.controller;

import com.example.demo.service.JestService;
import io.searchbox.client.JestClient;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("ElasticSearch演示")
@RestController
public class EsController {
    @Autowired
    private JestService jestService;

    private String indexName = "hwd";
    private String typeName = "user";

    @ApiOperation(value = "查找一个用户")
    @ApiImplicitParam(paramType = "path", name = "id", dataType = "String", required = true, value = "用户ID")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping(value = "/find/{id}")
    public Object find(@PathVariable String id) {
        return null;
//        return jestService.get(jestService.getJestClient(), );
    }
}
