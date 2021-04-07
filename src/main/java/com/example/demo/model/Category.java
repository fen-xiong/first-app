package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Category {
    private final String category_name;
    private  int UserId;
    private   String Ct;
    private   String Ut;
    public Category(@JsonProperty("category_name") String name){
        this.category_name = name;
    }
    public Category(int id , String name, String ct,String ut){
          UserId = id;
          category_name = name;
          Ct = ct;
          Ut = ut;
    }
    public void setId(int id) {
        this.UserId = id;
    }

    public int getUserId() {
        return UserId;
    }
    public String getName() {
        return category_name;
    }
    public String getCt() {
        return Ct;
    }
    public String getUt() {
        return Ut;
    }
}
