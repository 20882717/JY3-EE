package com.neuedu.Utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class ProUtil {
    //将String转成Date
    public static Date getStringForDate(String str)
    {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;

        try {
            java.util.Date date = sim.parse(str);
            date1 = new Date(date.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    //生产商品ID
   public static String getProId()
   {
       Random rd = new Random();
       int i = rd.nextInt(100);
       String str = null;
       str = String.valueOf(System.currentTimeMillis());

       if (i<10)
       {
           str += "0"+i;
       }
       return str +=i;
   }





}

