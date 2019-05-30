package com.neuedu.dao;

import com.neuedu.Utils.DruidDataSource;
import com.neuedu.entity.Prodact;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProdImpl implements Prod {

    private QueryRunner qr ;

    private DruidDataSource dds = DruidDataSource.getDataSource();

    public ProdImpl()
    {
        qr = new QueryRunner();
    }


    //添加
    @Override
    public void insertPro(Prodact pro) {

        String str = "INSERT INTO prodact VALUES (?,?,?,?,?,?,?,?,?)";
        Connection con = dds.getConnection();
        try {
            qr.update(con,str,pro.getPro_id(),pro.getPro_name(),pro.getPro_price(),pro.getPro_image(),pro.getPro_des(),pro.getPro_stock(),pro.getPro_date(),pro.getPro_category_id(),pro.getPro_factory());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            try {
                DbUtils.close(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    //查 询
    public List<Prodact> LiginProd()
    {
        String str = "SELECT * FROM prodact";
        Connection con = dds.getConnection();
        List<Prodact> list = null;
        try {
            list = qr.query(con,str,new BeanListHandler<>(Prodact.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //删除
    public void DelProd(Prodact prodact)
    {
        String str = "DELETE FROM prodact WHERE pro_id = ?";
        Connection con = dds.getConnection();
        try {
            qr.update(con,str,prodact.getPro_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //修改
    public void UpdateProd(Prodact prodact)
    {
        String str = "UPDATE prodact SET pro_name=?,pro_price=?,pro_image=?,pro_des=?,pro_stock=?,pro_date=?,pro_category_id=?,pro_factory=? WHERE pro_id=?";
        Connection con = dds.getConnection();
        try {
            qr.update(con,str,prodact.getPro_name(),prodact.getPro_price(),prodact.getPro_image(),prodact.getPro_des(),prodact.getPro_stock(),prodact.getPro_date(),prodact.getPro_category_id(),prodact.getPro_factory(),prodact.getPro_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






}
