package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public User insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    public User updateUser(User user) {
        return userMapper.getUser(user.getId());
    }

    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}
