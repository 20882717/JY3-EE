package com.neuedu.entity;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Users {

    private Integer id;

    private String username;

    private Date birthday;

    private Character sex;

    private String address;

    private List<Orders> orders;


}
