package com.neuedu.text;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query {

    private static final String URL = "jdbc:mysql://localhost:3306/jy3";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "lsq1960510";

    List<User> list = new ArrayList<>();

    public List<User> getQuery()
    {
        try {
            Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String str ="SELECT username,password FROM user";
            PreparedStatement pre = con.prepareStatement(str);
            ResultSet rs = pre.executeQuery();
            while (rs.next())
            {
                String username = rs.getString("username");
                String password = rs.getString("password");
                User user = new User(username,password);
                list.add(user);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
