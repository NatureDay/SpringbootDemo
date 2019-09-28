package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.util.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RequestMapping("/redis")
@RestController
public class RedisController {

    private static int sExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/set")
    public boolean redisset(@RequestParam String name) {
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        user.setCreateTime(new Date());

        //return redisUtil.set(key,user,ExpireTime);

        return redisUtil.set(name, user);
    }

    @RequestMapping("/get")
    public User redisget(@RequestParam String name) {
        return (User) redisUtil.get(name);
    }

    @RequestMapping("/expire")
    public boolean expire(String key) {
        return redisUtil.expire(key, sExpireTime);
    }

}
