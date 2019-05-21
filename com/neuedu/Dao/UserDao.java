package com.neuedu.Dao;

import com.neuedu.Entity.UserAndPsw;

public interface UserDao {

    //注册
    void getRegister(UserAndPsw up);

    //登录
    UserAndPsw getSing(UserAndPsw up);
}
