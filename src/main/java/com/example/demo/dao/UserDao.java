package com.example.demo.dao;

import com.example.demo.helper.DateToString;
import com.example.demo.model.User;


import java.util.List;
import java.util.UUID;

public interface UserDao extends DateToString {
    String newUser(UUID id , String create_time,  User user);

    default String newUser(User user) {
        String create_time = getCurrentTime();
        UUID id = UUID.randomUUID();
        return  newUser(id,create_time,user);

    }

    List<User> selectAll();
    public int checkAccount(String account);
    public int checkEmail(String email);
    public String signIn(String account ,String password);
}
