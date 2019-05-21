package com.neuedu.Servlet;

import com.neuedu.Dao.UserDao;
import com.neuedu.Dao.UserDaoImpl;
import com.neuedu.Entity.UserAndPsw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RegisterServlet",urlPatterns = "/Hello")
public class RegisterServlet extends HttpServlet {


    private UserDao ud;

    @Override
    public void init() throws ServletException {

        ud = new UserDaoImpl();
    }

    //    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String psw = request.getParameter("psw");
        UserAndPsw up = new UserAndPsw(user,psw);
        ud.getRegister(up);

        request.getRequestDispatcher("longin.jsp").forward(request,response);


    }
}
