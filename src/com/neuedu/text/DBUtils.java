package com.neuedu.text;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.List;

public class DBUtils {

    public static void main(String[] args) {

        QueryRunner qr = new QueryRunner();
        String str = "SELECT count(*) FROM user";
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jy3","root","lsq1960510");
            long list = (long)qr.query(con,str,new ScalarHandler());
           System.out.println(list);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
