package com.neuedu.text;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TestServlet",urlPatterns = "/Hello")
public class TestServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<User> names = new ArrayList<>();
        Query qe = new Query();
        List<User> user = qe.getQuery();
       for (User use:user)
       {
           System.out.println(use);
       }


//        names.add("张三");
//        names.add("李四");
//        names.add("王五");
//        request.setAttribute("name",names);
//        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
