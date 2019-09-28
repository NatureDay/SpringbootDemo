package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 控制器
 *
 * @RequestMapping("/") 和 @RequestMapping 是有区别的
 * 如果不写参数，则为全局默认页，加入输入404页面，也会自动访问到这个页面。
 * 如果加了参数“/”，则只认为是根页面。
 */
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
        user.setId(1);
        user.setName("aaa");
        return user;
    }

}