package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

//    User insertUser(User uesr);

    User getUser(int id);

//    User updateUser(int id);
//
//    User deleteUser(int id);

}
