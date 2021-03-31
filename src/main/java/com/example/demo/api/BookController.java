package com.example.demo.api;


import com.example.demo.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/book")
@RestController
public class BookController {
    private final Bookservice bookservice;

    @Autowired
    public BookController(Bookservice bookservice) {
        this.bookservice = bookservice;
    }

    @GetMapping(path="/self/all")
    public String getBookAll(@RequestHeader("Authorization") String token){
        System.out.println(token);
        return bookservice.getBookAll();
    }

}
