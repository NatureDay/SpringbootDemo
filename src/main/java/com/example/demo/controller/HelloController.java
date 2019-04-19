package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping
    public String hello() {
        return "Hello Spring-Boot";
    }

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setId("001");
        user.setName("aaa");
        return user;
    }

}