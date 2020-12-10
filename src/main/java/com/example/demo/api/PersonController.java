package com.example.demo.api;


import com.example.demo.model.User;
import com.example.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("note/user")
@RestController
public class PersonController {
    private final NoteService noteService;

    @Autowired
    public PersonController(NoteService noteService) {
        this.noteService = noteService;
    }
    @PostMapping
    public void addNote(@RequestBody User user) {
        noteService.addNote(user);
    }
    @GetMapping
    public List<User> selectAll() {
         return noteService.selectAll();
    }

}
