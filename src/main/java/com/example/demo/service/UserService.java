package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务层实现
 */
@Service
public class UserService implements UserMapper {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private RedisUtil redisUtil;


    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User queryUserById(Integer id) {
        String key = "id_" + id;
        User user = (User) redisUtil.get(key);
        User newUser;
        if (user == null) {
            newUser = userMapper.queryUserById(id);
            redisUtil.set(key, newUser);
        } else {
            newUser = user;
        }
        return newUser;
    }

    @Override
    public User queryUserByAccount(String account) {
        String key = "account_" + account;
        User user = (User) redisUtil.get(key);
        User newUser;
        if (user == null) {
            newUser = userMapper.queryUserByAccount(account);
            redisUtil.set(key, newUser);
        } else {
            newUser = user;
        }
        return newUser;
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public List<User> queryUsersByPermissions(List<Integer> ids) {
        return userMapper.queryUsersByPermissions(ids);
    }

    @Override
    public Role queryRole(Integer id) {
        return userMapper.queryRole(id);
    }

}
