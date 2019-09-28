package com.example.demo.controller;

import com.example.demo.base.CommonException;
import com.example.demo.base.Result;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.ResultUtil;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     *
     * @param params
     * @return
     */
    @PostMapping("/add")
    public Result<Void> addUser(@RequestParam Map<String, Object> params) {
        String account = (String) params.get("account");
        String pwd = (String) params.get("password");
        if (Strings.isNullOrEmpty(account) || Strings.isNullOrEmpty(pwd))
            throw CommonException.create("用户名或密码不可为空");
        User user = new User();
        user.setAccount(account);
        user.setPassword(pwd);
        user.setName((String) params.get("name"));
        user.setAddress((String) params.get("address"));
        user.setAge((Integer) params.get("age"));
        userService.insertUser(user);
        return ResultUtil.success(null);
    }

    /**
     * 查询单个用户
     *
     * @param id
     * @return
     */
    @GetMapping("/query/{id}")
    public Result<User> queryUser(@PathVariable(value = "id") Integer id) {
        if (id == null) throw CommonException.create("ID为空");
        return ResultUtil.success(userService.queryUserById(id));
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("/queryAll")
    public Result<List<User>> queryAllUser() {
        return ResultUtil.success(userService.queryAllUser());
    }

    /**
     * 更新用户
     *
     * @return
     */
    @PostMapping("/update/{id}")
    public Result<Void> update(@PathVariable(value = "id") Integer id, @RequestParam Map<String, Object> params) {
        if (id == null) throw CommonException.create("ID为空");
        User user = new User();
        user.setId(id);
        user.setName((String) params.get("name"));
        user.setAddress((String) params.get("address"));
        user.setAge((Integer) params.get("age"));
        userService.updateUser(user);
        return ResultUtil.success(null);
    }

    /**
     * 删除用户
     *
     * @return
     */
    @PostMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable(value = "id") Integer id) {
        if (id == null) throw CommonException.create("ID为空");
        userService.deleteUserById(id);
        return ResultUtil.success(null);
    }

//    @GetMapping("/query")
//    public Result<User> getUser(int id) {
//        return ResultUtil.success(userService.getUser(id));
//    }
//
//    @GetMapping("/query2")
//    public Result<User> getUser2(@RequestParam(value = "id") int ids) {
//        return ResultUtil.success(userService.getUser(ids));
//    }
//
//    @GetMapping("/query3/{id}")
//    public Result<User> getUser3(@PathVariable int id) {
//        User user = userService.getUser(id);
//        if (user == null) {
//            throw CommonException.create(10000, "没查到此人啊");
//        }
//        return ResultUtil.success(userService.getUser(id));
//    }
//
//    @GetMapping("/query4/{id}")
//    public Result<User> getUser4(@PathVariable(value = "id") int ids) {
//        return ResultUtil.success(userService.getUser(ids));
//    }
//
//    @PostMapping("/add")
//    public Result<User> addUser(@RequestBody Map<String, Object> params) {
//        User user = new User();
////        user.setName(data.getString("name"));
////        user.setAge(data.getInteger("age"));
//        userService.insertUser(params);
//        return ResultUtil.success(null);
//    }
//
//    @PutMapping("/update")
//    public Result<User> updateUser(@RequestBody JSONObject data) {
//        LogUtil.error("---------updateUser--------" + data);
//        User user = new User();
////        user.setId(data.getInteger("id"));
////        user.setName(data.getString("name"));
////        user.setAge(data.getInteger("age"));
//        return ResultUtil.success(null);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public Result<User> deleteUser(@PathVariable int id) {
//        userService.deleteUser(id);
//        return ResultUtil.success(null);
//    }
}
