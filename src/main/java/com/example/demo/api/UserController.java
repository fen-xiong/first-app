package com.example.demo.api;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("note/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public void newUser(@RequestBody User user) {
        userService.newUser(user);
    }
    @GetMapping
    public List<User> selectAll() {
         return userService.selectAll();
    }

}
