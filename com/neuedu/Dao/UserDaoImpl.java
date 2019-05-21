package com.neuedu.Dao;

import com.neuedu.DBUtils.DBUtils;
import com.neuedu.Entity.UserAndPsw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    //注册
    public void getRegister(UserAndPsw up)
    {
        Connection con = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String str = "INSERT INTO user(username,password) VALUES (?,?)";
        try {
            preparedStatement = con.prepareStatement(str);
            preparedStatement.setString(1,up.getUsername());
            preparedStatement.setString(2,up.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DBUtils.closePreparedStatement(preparedStatement);
            DBUtils.closeConnection(con);
        }

    }

    //登录
    public UserAndPsw getSing(UserAndPsw up) {
        Connection con = DBUtils.getConnection();
        PreparedStatement prep = null;
        ResultSet rs = null;
        String str = "SELECT username,password FROM user WHERE username=? AND password=?";
        try {
           prep = con.prepareStatement(str);
           prep.setString(1,up.getUsername());
           prep.setString(2,up.getPassword());
           rs = prep.executeQuery();
            if (rs.next())
            {
                return up;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResultSet(rs);
            DBUtils.closePreparedStatement(prep);
            DBUtils.closeConnection(con);

        }
        return null;
    }
}
