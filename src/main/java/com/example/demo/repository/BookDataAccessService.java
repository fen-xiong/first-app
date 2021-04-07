package com.example.demo.repository;


import com.example.demo.dao.BookDao;
import com.example.demo.helper.DateToString;
import com.example.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("Book")
public class BookDataAccessService implements BookDao , DateToString {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    BookDataAccessService(JdbcTemplate jdbcTemplate){
         this.jdbcTemplate = jdbcTemplate;
    }
    public List<Category> getUsersBooks(){
        LinkedList<Category> resultList = new LinkedList<>(){};
        String sql = "SELECT * FROM book_category WHERE user_id = ? ";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,1);
        list.forEach( (M) -> {
           int b_id =(int) M.get("book_category_id");
           String b_name =(String) M.get("book_category_name");
           Date c_t = (Date) M.get("created_at");
           Date u_t = (Date) M.get("updated_at");
           Category C = new Category(b_id,b_name,c_t.toString() , u_t != null ? u_t.toString() : "");
           resultList.addLast(C);
        });
        return resultList;
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
        return jdbcTemplate.update(sql, id);
    }

    public int editCategory(String name , int id ){
        String date = getCurrentTime();
        String sql = "UPDATE  book_category SET book_category_name = ? ,updated_at = ?  WHERE book_category_id = ?";
        return jdbcTemplate.update(sql, name,date, id);
    }

}
