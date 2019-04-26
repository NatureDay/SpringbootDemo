package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.base.Result;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.LogUtil;
import com.example.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/query")
    public Result<User> getUser(int id) {
        return ResultUtil.success(userService.getUser(id));
    }

    @GetMapping("/query2")
    public Result<User> getUser2(@RequestParam(value = "id") int ids) {
        return ResultUtil.success(userService.getUser(ids));
    }

    @GetMapping("/query3/{id}")
    public Result<User> getUser3(@PathVariable int id) {
        return ResultUtil.success(userService.getUser(id));
    }

    @GetMapping("/query4/{id}")
    public Result<User> getUser4(@PathVariable(value = "id") int ids) {
        return ResultUtil.success(userService.getUser(ids));
    }

    @PostMapping("/add")
    public Result<User> addUser(@RequestBody JSONObject data) {
        User user = new User();
        user.setName(data.getString("name"));
        user.setAge(data.getInteger("age"));
        return ResultUtil.success(userService.insertUser(user));
    }

    @PutMapping("/update")
    public Result<User> updateUser(@RequestBody JSONObject data) {
        LogUtil.error("---------updateUser--------" + data);
        User user = new User();
        user.setId(data.getInteger("id"));
        user.setName(data.getString("name"));
        user.setAge(data.getInteger("age"));
        return ResultUtil.success(null);
    }

    @DeleteMapping("/delete/{id}")
    public Result<User> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResultUtil.success(null);
    }
}
