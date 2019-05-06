package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    void insertUser(Map<String, Object> params);

    User getUser(int id);

    void updateUser(User user);

    void deleteUser(int id);

    User getUserByUsername(String userName);
}
