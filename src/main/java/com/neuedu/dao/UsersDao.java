package com.neuedu.dao;

import com.neuedu.entity.Users;

import java.util.List;

public interface UsersDao {

    //根据年龄和名字查询

    List<Users> getUserBySexAndName(Users users);

    List<Users> getIdByUser(Integer userId);
}
