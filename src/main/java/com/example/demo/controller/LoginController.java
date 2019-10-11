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
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/authc")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<User> login(@RequestBody Map<String, Object> params) {
        String account = (String) params.get("account");
        String password = (String) params.get("password");
        if (Strings.isNullOrEmpty(account) || Strings.isNullOrEmpty(password))
            throw CommonException.create(111, "用户名密码不能为空");

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(account, password);
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
        String account = (String) params.get("account");
        String pwd = (String) params.get("password");
        if (Strings.isNullOrEmpty(account) || Strings.isNullOrEmpty(pwd))
            throw CommonException.create(111, "用户名密码不能为空");
        User user = new User();
        user.setAccount(account);
        user.setPassword(pwd);

        /**
         * 为用户设定默认角色——游客
         */
        user.setRole(userService.queryRole(2));
        userService.insertUser(user);
        return ResultUtil.success(null, "注册成功");
    }

    @GetMapping("/logout")
    public Result<User> logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultUtil.success(null, "登出成功");
    }

    @GetMapping("/unauthorized")
    public Result<User> unauthorized() {
        throw CommonException.create(401, "权限不住");
    }

}
