package com.example.demo.controller;

import com.example.demo.base.CommonException;
import com.example.demo.base.Result;
import com.example.demo.model.User;
import com.example.demo.util.ResultUtil;
import com.google.common.base.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
        String userName = (String) params.get("userName");
        String password = (String) params.get("password");
        if (Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(password))
            throw CommonException.create(111, "用户名密码不能为空");

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);

        return ResultUtil.success(null);
    }

}
