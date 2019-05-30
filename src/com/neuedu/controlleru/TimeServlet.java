package com.neuedu.controlleru;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "TimeServlet",urlPatterns = "/time")
public class TimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = simpleDateFormat.format(date);
        Cookie cookie = new Cookie("time",str);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*7);
        response.addCookie(cookie);
        Cookie[] cookies = request.getCookies();
        if (null !=cookies)
        {
            String times = null;
            for (Cookie cookie1:cookies) {

                if ("time".equals(cookie1.getName()))
                {
                    times = cookie1.getValue();
                }

            }
            if (null !=times)
            {
                response.getWriter().write("上次登录时间为"+times);
            }else
            {
                response.getWriter().write("欢迎首次登录");
            }
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
