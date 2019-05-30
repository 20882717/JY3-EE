package com.neuedu.Utils;

import java.text.SimpleDateFormat;

import java.util.Date;

public class ObTime {

    public static String ObtainDate()
    {
        Date date = new Date();
        SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");

        String date1 = simp.format(date);

        return date1;

    }
}
