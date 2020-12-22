package com.example.demo.dao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
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
            String create_time = resultSet.getString("create_time");
            int user_id = resultSet.getInt("userid");
            return new User(id,user_id,account,password,email,create_time,name);
        });
    }

    @Override
    public int checkAccount(String account) {
        String sql = "SELECT id FROM users WHERE account = ?";
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
        jdbcTemplate.query(sql,new ArgumentPreparedStatementSetter(new Object[]{account}),countCallback);
        int result = countCallback.getColumnCount();
        if(result > 0)
            return 1;
        return 0;
    }

    @Override
    public int checkEmail(String email) {
        String sql = "SELECT id FROM users WHERE email = ?";
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
        jdbcTemplate.query(sql,new ArgumentPreparedStatementSetter(new Object[]{email}),countCallback);
        int result = countCallback.getColumnCount();
        if(result > 0)
            return 1;
        return 0;

    }
    @Override
    public boolean newUser(UUID id, String create_time , User U) {
        String sql = "insert into users (id,account,password,email,name , create_time) values (?,?,?,?,?,?)";
        String account = U.getAccount();
        String password = U.getPassword();
        String email = U.getEmail();
        String userName = U.getName();
        if(userName == "") {
            userName = account;
        }
        return jdbcTemplate.update(sql,id,account,password,email,userName ,  create_time ) >0 ;
    }
}

