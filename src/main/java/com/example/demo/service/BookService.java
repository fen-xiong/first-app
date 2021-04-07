package com.example.demo.service;


import com.example.demo.dao.BookDao;
import com.example.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookDao Bookdao;
    @Autowired
    public BookService(@Qualifier("Book") BookDao Bookdao) {
        this.Bookdao = Bookdao;
    }

    public List<Category> getUsersBooks() {
        return Bookdao.getUsersBooks();
    }

    public int newCategory(Category C) {
        return Bookdao.newCategory(C);
    }
    public int deleteCategory(int id) {
        return Bookdao.deleteCategory(id);
    }
    public int editCategory(String name ,int id) {
        return Bookdao.editCategory(name , id);
    }
}
