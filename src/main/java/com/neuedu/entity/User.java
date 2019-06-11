package com.neuedu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String id;

    private String username;

    private String password;

    private Date retime;





    public User(String id, String username, String password, Date retime) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.retime = retime;
    }

    public User(){}


}
