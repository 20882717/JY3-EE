package com.neuedu.controlleru;

import com.neuedu.Utils.FileAction;
import com.neuedu.Utils.ProUtil;

import com.neuedu.dao.ProdDao;

import com.neuedu.entity.Prodact;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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

        System.out.println(proName);
        System.out.println(proPrice);
        System.out.println(name);
        System.out.println(proDes);
        System.out.println(proStock);
        System.out.println(proDate);



        Prodact prodact = new Prodact(ProUtil.getProId(),proName,Double.parseDouble(proPrice),name,proDes,Integer.parseInt(proStock),ProUtil.getStringForDate(proDate),Integer.parseInt(proCateid),proFact);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));

        SqlSession sqlSession = build.openSession();

        ProdDao mapper = sqlSession.getMapper(ProdDao.class);

        mapper.insertPro(prodact);

        sqlSession.commit();


        request.getRequestDispatcher("logprod").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
