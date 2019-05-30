package com.neuedu.dao;

import com.neuedu.entity.Prodact;

import java.util.List;

public interface Prod {

    //添加
    void insertPro(Prodact pro);

    //查询
    List<Prodact> LiginProd();

    //删除
    void DelProd(Prodact prodact);

    //修改
    void UpdateProd(Prodact prodact);
}
