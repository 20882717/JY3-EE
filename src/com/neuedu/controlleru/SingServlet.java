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

@WebServlet(name = "SingServlet",urlPatterns = "/sing")
public class SingServlet extends HttpServlet {

    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String psw = request.getParameter("psw");
        User user1 = new User(ProUtil.getProId(),user,psw,ProUtil.getStringForDate(ObTime.ObtainDate()));

        boolean result = ud.SingUser(user1);
        if (result ==true)
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
