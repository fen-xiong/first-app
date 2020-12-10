package com.example.demo.dao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository("User")
public class UserDataAccessService implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
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
    public boolean newUser(UUID id, User U) {
        String sql = "insert into users (id,account,password,email,name) values (?,?,?,?,?)";
        String account = U.getAccount();
        String password = U.getPassword();
        String email = U.getEimal();
        String userName = U.getName();
        return jdbcTemplate.update(sql,id,account,password,email,userName) >0 ;
    }
}
