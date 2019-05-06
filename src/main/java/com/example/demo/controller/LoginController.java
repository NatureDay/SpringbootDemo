package com.example.demo.controller;

import com.example.demo.base.Result;
import com.example.demo.model.User;
import com.example.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public Result<User> login(@RequestBody Map<String, Object> params) {


        return ResultUtil.success(null);
    }

}
