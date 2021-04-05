package com.example.demo.repository;


import com.example.demo.dao.BookDao;
import com.example.demo.helper.DateToString;
import com.example.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("Book")
public class BookDataAccessService implements BookDao , DateToString {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    BookDataAccessService(JdbcTemplate jdbcTemplate){
         this.jdbcTemplate = jdbcTemplate;
    }
    public String getBookAll(){
        return "hello word";
    }


    public int newCategory(Category c) {
        String sql = "insert into book_category (user_id , book_category_name , created_at) values (?,?,?)  RETURNING book_category_id";
        String N = c.getName();
        int ID = c.getUserId();
        String create_time = getCurrentTime();
        Map<String, Object> result = jdbcTemplate.queryForMap( sql, ID, N, create_time);
        return (int)result.get("book_category_id");
    }

    public int deleteCategory(int id){
        String sql = "DELETE FROM book_category WHERE book_category_id = ?";
        int Row =  jdbcTemplate.update(sql, id);
        return Row;

    }


}
