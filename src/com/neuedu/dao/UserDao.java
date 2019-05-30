package com.neuedu.dao;

import com.neuedu.entity.User;

public interface UserDao {

    //注册
    void LonginUser(User user);

    //登录
    boolean SingUser(User user);
}
