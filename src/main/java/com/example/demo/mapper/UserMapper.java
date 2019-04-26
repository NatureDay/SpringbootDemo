package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User insertUser(User user);

    User getUser(int id);

    void updateUser(User user);

    void deleteUser(int id);

}
