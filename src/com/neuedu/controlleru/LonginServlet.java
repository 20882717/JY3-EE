package com.neuedu.controlleru;

import com.neuedu.Utils.ObTime;
import com.neuedu.Utils.ProUtil;
import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LonginServlet",urlPatterns ="/longin")
public class LonginServlet extends HttpServlet {

    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String user = request.getParameter("user");
                String psw = request.getParameter("psw");

                User users = new User(ProUtil.getProId(),user,psw,ProUtil.getStringForDate(ObTime.ObtainDate()));

                ud.LonginUser(users);

                request.getRequestDispatcher("sing.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
