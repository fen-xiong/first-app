package com.example.demo.api;


import com.example.demo.model.Category;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RequestMapping("/book")
@RestController
public class BookController {
    private final BookService BookService;

    @Autowired
    public BookController(BookService bookservice) {
        this.BookService = bookservice;
    }

    @GetMapping(path="/self/all")
    public String getBookAll(@RequestAttribute("user_id") int UserId){
        return BookService.getBookAll();

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
}
