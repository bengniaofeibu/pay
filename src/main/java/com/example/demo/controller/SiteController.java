package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class SiteController {

    @ApiIgnore
    @GetMapping(value = "/")
    public String index() {
        return "hello";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam(value = "user_name") String userName, @RequestParam(value = "user_password") String userPassword){
        return userName + ":" + userPassword;
    }

}
