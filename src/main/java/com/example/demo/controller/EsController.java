package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.JestService;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.swagger.annotations.*;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import java.rmi.ServerException;
import java.util.HashMap;
import java.util.Map;

@Api("ElasticSearch演示")
@RestController
public class EsController {
    private final Logger logger = LoggerFactory.getLogger(EsController.class);
    private JestService jestService;

    @Autowired
    public EsController(JestService jestService) {
        this.jestService = jestService;
    }

    private String indexName = "hwd";
    private String typeName = "user";

    @ApiOperation(value = "查找一个用户")
    @ApiImplicitParam(paramType = "path", name = "id", dataType = "String", required = true, value = "用户ID")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求数据不存在")
    })
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Map<String, Object>> find(@PathVariable String id) throws Exception {
        Map<String, Object> map = new HashMap<>();
        JestClient client = jestService.getJestClient();
        JestResult res = jestService.get(client, "order", "list", id);
        User user = res.getSourceAsObject(User.class);
        if (user == null) {
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        map.put("data", user);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
