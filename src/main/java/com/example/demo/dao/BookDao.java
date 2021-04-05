package com.example.demo.dao;

import com.example.demo.model.Category;


public interface BookDao {
    String getBookAll();

    int newCategory(Category c);
    int deleteCategory(int id);
}
