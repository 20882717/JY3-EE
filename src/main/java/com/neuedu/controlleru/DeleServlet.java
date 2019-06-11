package com.neuedu.controlleru;

import com.neuedu.Utils.ProUtil;

import com.neuedu.dao.ProdDao;
import com.neuedu.entity.Prodact;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleServlet",urlPatterns = "/del")
public class DeleServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pro_id = request.getParameter("pro_id");
        String pro_name = request.getParameter("pro_name");
        String pro_price = request.getParameter("pro_price");
        String image = request.getParameter("pro_image");
        String pro_des = request.getParameter("pro_des");
        String pro_stock = request.getParameter("pro_stock");
        String pro_date = request.getParameter("pro_date");
        String pro_category_id = request.getParameter("pro_category_id");
        String  pro_factory = request.getParameter("pro_factory");


        Prodact prodact = new Prodact(pro_id,pro_name,Double.parseDouble(pro_price),image,pro_des,Integer.parseInt(pro_stock),ProUtil.getStringForDate(pro_date),Integer.parseInt(pro_category_id),pro_factory);

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));

        SqlSession sqlSession = build.openSession();

        ProdDao mapper = sqlSession.getMapper(ProdDao.class);

        mapper.DelProd(prodact);

        sqlSession.commit();


        request.getRequestDispatcher("logprod").forward(request,response);
    }
}
