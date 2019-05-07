package com.example.demo.controller;

import com.example.demo.base.CommonException;
import com.example.demo.base.Result;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.ResultUtil;
import com.google.common.base.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Result<User> login(@RequestBody Map<String, Object> params) {
        String userName = (String) params.get("userName");
        String password = (String) params.get("password");
        if (Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(password))
            throw CommonException.create(111, "用户名密码不能为空");

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
        } catch (IncorrectCredentialsException e) {
            return ResultUtil.failure(101, "用户名密码错误");
        } catch (UnknownAccountException e) {
            return ResultUtil.failure(102, "用户名密码错误");
        } catch (AuthenticationException e) {
            return ResultUtil.failure(110, "登录失败");
        }
        return ResultUtil.success(null, "登陆成功");
    }

    @PostMapping("/register")
    public Result<User> register(@RequestBody Map<String, Object> params) {
        String userName = (String) params.get("userName");
        String password = (String) params.get("password");
        if (Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(password))
            throw CommonException.create(111, "用户名密码不能为空");
        userService.insertUser(params);
        return ResultUtil.success(null, "注册成功");
    }

    @PostMapping("/logout")
    public Result<User> logout(@RequestBody Map<String, Object> params) {
        String userName = (String) params.get("userName");
        String password = (String) params.get("password");
        if (Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(password))
            throw CommonException.create(111, "用户名密码不能为空");

        return ResultUtil.success(null, "登出成功");
    }

}