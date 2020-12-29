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
    public String newUser(@RequestBody User user) {
        userService.newUser(user);
        return "success";
    }
    @PostMapping(path = "/signIn")
    public String signIn(@RequestBody User user) {
        userService.signIn(user.getAccount(), user.getPassword());
        return "success";
    }
    @GetMapping
    public List<User> selectAll() {
         return userService.selectAll();
    }

    @GetMapping(value = "/hasAccount/{account}")
    public int checkAccount(@PathVariable String account) {
        return userService.checkAccount(account);
    }
    @GetMapping(value = "/hasEmail/{email}")
    public int checkEmail(@PathVariable String email) {
        return userService.checkEmail(email);
    }
}
