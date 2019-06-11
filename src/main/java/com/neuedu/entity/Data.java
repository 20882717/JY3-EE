package com.neuedu.entity;

import java.sql.Date;

@lombok.Data
public class Data {

    private String id;

    private String username;

    private String password;

    private Date retime;

    public Data(String id, String username, String password, Date retime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.retime = retime;
    }

    public Data(){}
}
