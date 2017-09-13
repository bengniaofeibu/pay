package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void set() throws Exception {
        assertEquals(true, redisService.set("test", "Hello World!"));
    }

    @Test
    public void get() throws Exception {
        redisService.set("test", "Hello World!");
        assertEquals("Hello World!", redisService.get("test"));
    }

    @Test
    public void expire() throws Exception {
        redisService.set("test", "Hello World!");
        assertEquals(true, redisService.expire("test", 1));
        Thread.sleep(1000);
        assertEquals(null, redisService.get("test"));
    }

    @Test
    public void list() throws Exception {
        redisService.expire("testlist", 0);
        String str1 = "str1";
        String str2 = "str2";
        redisService.rPush("testlist", str1);
        redisService.rPush("testlist", str2);
        String res1 = redisService.lPop("testlist");
        String res2 = redisService.lPop("testlist");
//        System.out.println(res1);
//        System.out.println(res2);
//        assertTrue(res1.equals("str1"));
//        assertTrue(res1.equals("str2"));
//        redisService.expire("testlist", 0);
    }
}