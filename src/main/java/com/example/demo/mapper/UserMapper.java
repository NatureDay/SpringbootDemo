package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("SELECT * FROM User WHERE id = #{id}")
    User selectUser(int id);

}
