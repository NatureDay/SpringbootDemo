package com.example.demo.controller;

import com.example.demo.base.Result;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/query/{id}")
    public Result<User> getUser(@PathVariable int id) {
        return ResultUtil.success(userService.getUser(id));
    }

    @PostMapping("/add")
    public User addUser(@RequestParam User user) {
        return userService.getUser(user.getId());
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.getUser(user.getId());
    }

    @DeleteMapping("/delete")
    public User deleteUser(@RequestBody User user) {
        return userService.getUser(user.getId());
    }
}
