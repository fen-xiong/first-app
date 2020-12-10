package com.example.demo.dao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository("Note")
public class NoteDataAccessService implements  NoteDao  {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public NoteDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> selectAll() {
        final String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql,(resultSet,i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String account = resultSet.getString("account");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            return new User(id,account,password,email,name);

        });
    }

    @Override
    public int addNote(User user) {
        return 0;
    }

    @Override
    public int addNote(UUID id, User person) {
        return 0;
    }
}
