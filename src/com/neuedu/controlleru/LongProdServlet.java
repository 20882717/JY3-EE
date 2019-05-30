package com.neuedu.controlleru;

import com.neuedu.dao.Prod;
import com.neuedu.dao.ProdImpl;
import com.neuedu.entity.Prodact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LongProdServlet",urlPatterns = "/logprod")
public class LongProdServlet extends HttpServlet {

    private Prod prod;

    @Override
    public void init() throws ServletException {
        prod = new ProdImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Prodact> list = prod.LiginProd();



        request.setAttribute("prods",list);

        request.getRequestDispatcher("longprod.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
