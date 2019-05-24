package com.neuedu.controlleru;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(name = "UploadServlet",urlPatterns = "/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part part = request.getPart("file1");
        String str = part.getSubmittedFileName();
        InputStream ins = part.getInputStream();
        OutputStream outs = new FileOutputStream("c://img//"+str);
        int buffer = 0;
        byte[] bs = new byte[1024];
        while ((buffer = ins.read(bs))!=-1)
        {
            outs.write(bs,0,buffer);
        }
        outs.close();
        ins.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
