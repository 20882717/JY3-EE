package com.neuedu.dao;

import com.neuedu.entity.OrderUser;

import java.util.List;

public interface OrderUserDao {

    //查询商品对应用户
    List<OrderUser> getOrderAndUser();
}
