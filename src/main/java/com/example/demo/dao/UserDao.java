package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    int newUser(UUID id , User user);

    default int newUser(User user) {
        UUID id = UUID.randomUUID();
        newUser(id,user);
        return 1;
    }
    List<User> selectAll();

}
