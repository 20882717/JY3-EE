package com.neuedu.dao;

import com.neuedu.entity.Data;

public interface DataDao {

    //根据ID查询用户信息
    public Data getUser(String username);

    public String addUserReturnId(Data data);

    //添加用户
    public void insertOneUser(Data data);

    //删除用户
    public void delOneUser(String id);
}
