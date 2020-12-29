package com.example.demo.dao;

import com.example.demo.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface UserDao {
    boolean newUser(UUID id , String create_time,  User user);

    default int newUser(User user) {
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String create_time = df2.format(new Date());
        UUID id = UUID.randomUUID();
        newUser(id,create_time,user);
        return 1;
    }
    List<User> selectAll();
    public int checkAccount(String account);
    public int checkEmail(String email);
    public String signIn(String account ,String password);
}
