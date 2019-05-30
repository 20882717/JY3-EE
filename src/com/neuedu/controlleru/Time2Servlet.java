package com.neuedu.controlleru;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Time2Servlet",urlPatterns = "/times")
public class Time2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String user = request.getParameter("username");
            String psw = request.getParameter("psw");
           if (null !=user && null != psw)
           {
               Cookie username = new Cookie("username",user);
               Cookie psw1 = new Cookie("psw",psw);
               username.setMaxAge(60);
               psw1.setMaxAge(60);
               response.addCookie(username);
               response.addCookie(psw1);

           }else
           {
               Cookie[] cookies = request.getCookies();
               for (Cookie c:cookies) {

                  if ("username".equals(c.getName()) )
                  {
                      user = c.getValue();
                  }
                  if ("psw".equals(c.getName()))
                  {
                      psw = c.getValue();
                  }

               }
           }
           if (user !=null && psw != null)
           {
              request.getRequestDispatcher("time2.jsp").forward(request,response);
           }else
           {
               request.getRequestDispatcher("time.jsp").forward(request,response);
           }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
