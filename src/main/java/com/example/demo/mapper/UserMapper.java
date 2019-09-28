package com.example.demo.mapper;

import com.example.demo.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    void insertUser(Map<String, Object> params);

    UserEntity getUser(int id);

    void updateUser(UserEntity userEntity);

    void deleteUser(int id);

    UserEntity getUserByUsername(String userName);
}
