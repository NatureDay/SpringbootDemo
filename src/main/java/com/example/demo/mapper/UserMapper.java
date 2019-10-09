package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * dao层
 */
@Mapper
public interface UserMapper {

    /**
     * 新增用户信息
     *
     * @param user
     */
    void insertUser(User user);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> queryAllUser();

    /**
     * 根据Id查询用户信息
     *
     * @param id
     * @return
     */
    User queryUserById(Integer id);

    /**
     * 根据账户名查询用户信息
     *
     * @param account
     * @return
     */
    User queryUserByAccount(String account);

    /**
     * 根据id更新用户信息
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    void deleteUserById(Integer id);

    /**
     * 根据传入的权限ID来查询拥有权限的用户
     *
     * @param ids
     */
    List<User> queryUsersByPermissions(@Param("ids") List<Integer> ids);
}
