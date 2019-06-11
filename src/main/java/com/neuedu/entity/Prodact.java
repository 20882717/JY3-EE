package com.neuedu.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Prodact {

    private String pro_id;
    private String pro_name;
    private Double pro_price;
    private String pro_image;
    private String pro_des;
    private Integer pro_stock;
    private Date pro_date;
    private Integer pro_category_id;
    private String pro_factory;

    public Prodact(String pro_id, String pro_name, Double pro_price, String pro_image, String pro_des, Integer pro_stock, Date pro_date, Integer pro_category_id, String pro_factory) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_price = pro_price;
        this.pro_image = pro_image;
        this.pro_des = pro_des;
        this.pro_stock = pro_stock;
        this.pro_date = pro_date;
        this.pro_category_id = pro_category_id;
        this.pro_factory = pro_factory;
    }




    public Prodact(){}


}
