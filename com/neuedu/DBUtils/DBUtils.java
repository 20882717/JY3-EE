package com.neuedu.DBUtils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtils {

    private  static  Properties properties;

    //静态代码块
    static {

        properties = new Properties();
        try {
            properties.load(DBUtils.class.getResourceAsStream("/mysql.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
           Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
           e.printStackTrace();
      }
    }

    //拿到配置文件中的URL
    private static final String URL = properties.getProperty("url");

    //拿到配置文件中的USERNAME
    private static final String USERNAME = properties.getProperty("username");

    //拿到配置文件中的PASSWORD
    private static final String PASSWORD = properties.getProperty("password");

    public static Connection getConnection()
    {   Connection conn = null;
        if (conn == null)
        {
            try {
                conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;


    }

    //关闭连接
    public static void closeConnection(Connection con)
    {
        if (null != con)
        {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //关闭连接
    public static void closePreparedStatement(PreparedStatement preparedStatement)
    {
        if (null != preparedStatement)
        {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //关闭连接
    public static void closeResultSet(ResultSet rs)
    {
        if (null != rs)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }







}
