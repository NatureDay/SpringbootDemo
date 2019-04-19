package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping
    public String hello() {
        return "Hello Spring-Boot";
    }

    @RequestMapping("/info")
    public Map<String, String> getInfo(@RequestParam String name) {
        Map<String, String> result = new HashMap<>();
        result.put("name", name);
        return result;
    }

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setId("001");
        user.setName("aaa");
        return user;
    }

}