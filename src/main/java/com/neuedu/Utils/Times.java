package com.neuedu.Utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Times {

    public static Date getTime(String str)
    {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date date = simpleDateFormat.parse(str);
            Date date1 = new Date(date.getTime());
            return date1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    }
