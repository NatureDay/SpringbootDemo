package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public void insertUser(Map<String, Object> params) {
        userMapper.insertUser(params);
    }

    public UserEntity getUser(int id) {
        return userMapper.getUser(id);
    }

    public void updateUser(UserEntity userEntity) {
        userMapper.updateUser(userEntity);
    }

    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    public UserEntity getUserByUsername(String userName) {
        return userMapper.getUserByUsername(userName);
    }

}
