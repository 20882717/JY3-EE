package com.neuedu.dao;

import com.neuedu.entity.Orders;

import java.util.List;

public interface OrdersDao {

    //查询所有
    public List<Orders> getAllOrders();

    public List<Orders> getOrdersAndUsers();
}
