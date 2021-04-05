package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Category {
    private final String category_name;
    private  int UserId;

    public Category(@JsonProperty("category_name") String name){
        this.category_name = name;
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
}
