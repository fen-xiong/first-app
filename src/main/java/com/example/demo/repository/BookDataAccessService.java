package com.example.demo.repository;


import com.example.demo.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("Book")
public class BookDataAccessService implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    BookDataAccessService(JdbcTemplate jdbcTemplate){
         this.jdbcTemplate = jdbcTemplate;
    }
    public String getBookAll(){
        return "hello word";
    }
}
