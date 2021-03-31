package com.example.demo.service;


import com.example.demo.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Bookservice {
    private final BookDao Bookdao;
    @Autowired
    public Bookservice(@Qualifier("Book") BookDao Bookdao) {
        this.Bookdao = Bookdao;
    }

    public String getBookAll() {
        return Bookdao.getBookAll();
    }
}
