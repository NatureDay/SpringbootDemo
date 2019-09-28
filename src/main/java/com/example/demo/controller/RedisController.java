package com.example.demo.controller;

import com.example.demo.model.UserEntity;
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
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("张三");
        userEntity.setCreateTime(new Date());

        //return redisUtil.set(key,userEntity,ExpireTime);

        return redisUtil.set(name, userEntity);
    }

    @RequestMapping("/get")
    public UserEntity redisget(@RequestParam String name) {
        return (UserEntity) redisUtil.get(name);
    }

    @RequestMapping("/expire")
    public boolean expire(String key) {
        return redisUtil.expire(key, sExpireTime);
    }

}
