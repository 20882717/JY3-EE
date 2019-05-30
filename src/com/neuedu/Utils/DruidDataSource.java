package com.neuedu.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DruidDataSource {

    private static Properties prop = new Properties();

    private static DruidDataSource ds = null;

    private DruidDataSource()
    {

    }

    public static DruidDataSource getDataSource()
    {
        if (null == ds)
        {
            ds = new DruidDataSource();
        }
        return ds;
    }


    public static Connection getConnection()
    {
        try {
            prop.load(DruidDataSource.class.getResourceAsStream("/mysql.properties"));
            try {
                DataSource ds = DruidDataSourceFactory.createDataSource(prop);
                Connection con = ds.getConnection();
                return con;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
