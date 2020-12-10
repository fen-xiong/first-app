package com.example.demo.service;

import com.example.demo.dao.NoteDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteDao noteDay;

    @Autowired
    public NoteService(@Qualifier("Note") NoteDao noteDay) {
        this.noteDay = noteDay;
    }
    public int addNote(User user) {
        return noteDay.addNote(user);
    }
    public List<User> selectAll() {
        return noteDay.selectAll();
    }

}
