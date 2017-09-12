package com.example.demo.service;

import com.example.demo.entity.User;
import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() throws Exception {
    }

    @Test
    public void fineById() throws Exception {
        User user = userService.fineById(2);
        Assert.assertEquals(new Integer(2), user.getId());
        Assert.assertEquals("u2", user.getUserName());
    }

    @Test
    public void list() throws Exception {
    }

    @Test
    public void isExsited() throws Exception {
    }

}