package com.example.demo.dao;

import com.example.demo.model.Category;

import java.util.List;


public interface BookDao {
    List<Category> getUsersBooks();

    int newCategory(Category c);
    int deleteCategory(int id);
    int editCategory(String name, int id);
}
