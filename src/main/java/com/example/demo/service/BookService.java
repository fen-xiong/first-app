package com.example.demo.service;


import com.example.demo.dao.BookDao;
import com.example.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookDao Bookdao;
    @Autowired
    public BookService(@Qualifier("Book") BookDao Bookdao) {
        this.Bookdao = Bookdao;
    }

    public String getBookAll() {
        return Bookdao.getBookAll();
    }

    public int newCategory(Category C) {
        return Bookdao.newCategory(C);
    }
    public int deleteCategory(int id) {
        return Bookdao.deleteCategory(id);
    }
}
