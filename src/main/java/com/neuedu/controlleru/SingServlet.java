package com.neuedu.controlleru;

import com.neuedu.Utils.ObTime;
import com.neuedu.Utils.ProUtil;

import com.neuedu.dao.UserDao;
import com.neuedu.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SingServlet",urlPatterns = "/sing")
public class SingServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(1);
        String user = request.getParameter("users");

        String psw = request.getParameter("psw");

        System.out.println(user);

        System.out.println(psw);
        User user1 = new User(ProUtil.getProId(),user,psw,ProUtil.getStringForDate(ObTime.ObtainDate()));

        SqlSessionFactory sqlMapConfig = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));

        SqlSession sqlSession = sqlMapConfig.openSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user2 = mapper.SingUser(user1);



        if (user2.getUsername().equals(user) && user2.getPassword().equals(psw))
        {
           request.getRequestDispatcher("logprod").forward(request,response);
        }  else
        {
            request.getRequestDispatcher("longin.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
