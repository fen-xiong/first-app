package com.example.demo.api;


import com.example.demo.model.Category;
import com.example.demo.service.BookService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {
    private final BookService BookService;

    @Autowired
    public BookController(BookService bookservice) {
        this.BookService = bookservice;
    }

    @GetMapping(path="/self/all")
    public List<Category> getUsersBooks(@RequestAttribute("user_id") int UserId){
        return BookService.getUsersBooks();

    }
    @PostMapping(path = "/category/new")
    public int newCategory(@RequestBody Category category, @RequestAttribute("user_id") int UserId) {
        category.setId(UserId);
       return BookService.newCategory(category);
    }

    @DeleteMapping(path = "/category/del/{id}")
    public  int deleteCategory(@PathVariable("id") int id){
        return BookService.deleteCategory(id);
    }

    @PostMapping(path = "/category/edit/{id}")
    public  int editCategory(@PathVariable("id") int id , @RequestBody Category c) {
        return BookService.editCategory(c.getName(),id);
    }
}
