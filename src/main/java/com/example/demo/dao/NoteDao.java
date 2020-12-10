package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;
import java.util.UUID;

public interface NoteDao {
    int addNote(UUID id , User person);

    default int addNote(User user) {
        UUID id = UUID.randomUUID();
        addNote(id,user);
        return 1;
    }
    List<User> selectAll();

}
