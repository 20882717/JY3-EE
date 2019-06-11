package com.neuedu.Utils;

import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

public class FileAction {

    public static String uploadFile(Part part)
    {
        String str = part.getSubmittedFileName();
        InputStream ins = null;
        try {
            ins = part.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建随机数UUID
        UUID uuid = UUID.randomUUID();
        String name = uuid+str;
        OutputStream outs = null;
        try {
            outs = new FileOutputStream("c://img//"+name);
            int buffer = 0;
            byte[] bs = new byte[1024];
            try {
                while ((buffer = ins.read(bs))!=-1)
                {
                    outs.write(bs,0,buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            outs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;

    }
}
