package com.neuedu.controlleru;


import com.neuedu.Utils.FileAction;
import com.neuedu.Utils.ProUtil;
import com.neuedu.dao.Prod;
import com.neuedu.dao.ProdImpl;
import com.neuedu.entity.Prodact;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.IOException;

@WebServlet(name = "UpdateServlet",urlPatterns ="/update")
@MultipartConfig
public class UpdateServlet extends HttpServlet {
    private Prod prod;

    @Override
    public void init() throws ServletException {
        prod = new ProdImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            String pro_id = request.getParameter("pro_id");
            String pro_name = request.getParameter("pro_name");
            String pro_price = request.getParameter("proPrice");
           Part feli = request.getPart("file1");
           String image = FileAction.uploadFile(feli);
//         String image = request.getParameter("file1");
            String pro_des = request.getParameter("proDes");

            String pro_stock = request.getParameter("proStock");
            String pro_date = request.getParameter("proDate");
            String pro_category_id = request.getParameter("proCateid");
            String pro_factory = request.getParameter("proFact");
            System.out.println(pro_id);
            System.out.println(pro_name);
            System.out.println(pro_price);
            System.out.println(image);
            System.out.println(pro_des);
            System.out.println(pro_stock);
            System.out.println(pro_date);
            System.out.println(pro_category_id);
            System.out.println(pro_factory);
            Prodact prodact = new Prodact(pro_id,pro_name,Double.parseDouble(pro_price),image,pro_des,Integer.parseInt(pro_stock),ProUtil.getStringForDate(pro_date),Integer.parseInt(pro_category_id),pro_factory);
           prod.UpdateProd(prodact);

        request.getRequestDispatcher("logprod").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
