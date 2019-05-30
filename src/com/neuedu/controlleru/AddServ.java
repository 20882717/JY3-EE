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

@WebServlet(name = "AddServ",urlPatterns ="/add" )
@MultipartConfig
public class AddServ extends HttpServlet {

    private Prod pro;

    @Override
    public void init() throws ServletException {
        pro = new ProdImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String proName = request.getParameter("proName");
        String proPrice = request.getParameter("proPrice");
        //拿到图片并上传到服务器
        Part file1 = request.getPart("file1");
        String name = FileAction.uploadFile(file1);
        String proDes = request.getParameter("proDes");
        String proStock = request.getParameter("proStock");
        String proDate = request.getParameter("proDate");
        String proCateid = request.getParameter("proCateid");
        String proFact = request.getParameter("proFact");

        Prodact prodact = new Prodact(ProUtil.getProId(),proName,Double.parseDouble(proPrice),name,proDes,Integer.parseInt(proStock),ProUtil.getStringForDate(proDate),Integer.parseInt(proCateid),proFact);

        pro.insertPro(prodact);
        request.getRequestDispatcher("logprod").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
