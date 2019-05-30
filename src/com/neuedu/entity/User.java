package com.neuedu.entity;

import java.util.Date;

public class User {

    private String id;

    private String username;

    private String password;

    private Date retime;


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", retime=" + retime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRetime() {
        return retime;
    }

    public void setRetime(Date retime) {
        this.retime = retime;
    }

    public User(String id, String username, String password, Date retime) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.retime = retime;
    }

    public User(){}


}
