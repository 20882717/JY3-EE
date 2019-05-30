package com.neuedu.controlleru;


import com.neuedu.Utils.FileAction;
import com.neuedu.Utils.ProUtil;

import com.neuedu.entity.Prodact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.IOException;

@WebServlet(name = "shoeDatesServlet",urlPatterns = "/show" )
public class shoeDatesServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pro_id = request.getParameter("pro_id");
        String pro_name = request.getParameter("pro_name");
        String pro_price = request.getParameter("pro_price");
        //拿到图片并上传到服务器
//        Part file1 = request.getPart("pro_image");
//        String image = FileAction.uploadFile(file1);
        String image = request.getParameter("pro_image");
        String pro_des = request.getParameter("pro_des");
        String pro_stock = request.getParameter("pro_stock");
        String pro_date = request.getParameter("pro_date");
        String pro_category_id = request.getParameter("pro_category_id");
        String  pro_factory = request.getParameter("pro_factory");




       Prodact prodact = new Prodact(pro_id,pro_name,Double.parseDouble(pro_price),image,pro_des,Integer.parseInt(pro_stock),ProUtil.getStringForDate(pro_date),Integer.parseInt(pro_category_id),pro_factory);

        request.setAttribute("prod",prodact);

       request.getRequestDispatcher("update.jsp").forward(request,response);
    }
}
