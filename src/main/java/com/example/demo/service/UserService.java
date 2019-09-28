package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 */
@Service
public class UserService implements UserMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        return null;
    }

    @Override
    public User queryUserById(Integer id) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(Integer id) {

    }

}
