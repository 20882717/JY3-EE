package com.neuedu.dao;

import com.neuedu.Utils.DruidDataSource;
import com.neuedu.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private QueryRunner qr;

    private DruidDataSource dds = DruidDataSource.getDataSource();

    public UserDaoImpl()
    {
        qr = new QueryRunner();
    }

   //注册
    public void LonginUser(User user)
    {
        String str = "INSERT INTO user VALUES (?,?,?,?)";
        Connection con = dds.getConnection();
        try {
            qr.update(con,str,user.getId(),user.getUsername(),user.getPassword(),user.getRetime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //登录
    public  boolean SingUser(User user)
    {
        String str = "SELECT username,password FROM user WHERE username = ? AND password = ?";
        Connection con = dds.getConnection();

        try {
            User user1 = qr.query(con,str,new BeanHandler<>(User.class),user.getUsername(),user.getPassword());
            if (null != user1)
            {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
