package com.neuedu.controlleru;


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
import java.util.List;


@WebServlet(name = "LongProdServlet",urlPatterns = "/logprod")
public class LongProdServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SqlSessionFactory sqlMapConfig = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));

        SqlSession sqlSession = sqlMapConfig.openSession();

        ProdDao mapper = sqlSession.getMapper(ProdDao.class);

        List<Prodact> list = mapper.LiginProd();

        for (Prodact c: list) {

            System.out.println(c);

        }

        req.setAttribute("prods",list);

        req.getRequestDispatcher("longprod.jsp").forward(req,resp);

    }
}
