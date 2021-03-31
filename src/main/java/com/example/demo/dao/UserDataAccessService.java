package com.example.demo.dao;

import com.example.demo.helper.DateToString;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("User")
public class UserDataAccessService implements UserDao, DateToString {

    private final JdbcTemplate jdbcTemplate;
    private static JdbcTemplate jdbcTemplate2;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        UserDataAccessService.jdbcTemplate2 = jdbcTemplate;
    }

    @Override
    public String signIn(String account, String password) {
        String sql = "SELECT password,userid FROM users WHERE account = ?";
        try {
            Map<String, Object> result = jdbcTemplate.queryForMap(sql, account);
            String dataPassword = (String) result.get("password");
            if (dataPassword.equals(password)) {
                Integer userid = (Integer) result.get("userid");
                String tSql = "SELECT token FROM users_token WHERE userid = ?";
                Map<String, Object> tokenMap = jdbcTemplate.queryForMap(tSql, userid);
                String token = (String) tokenMap.get("token");
                return token;
            }else{
                return "PASSWORD_NO";
            }

        } catch (EmptyResultDataAccessException e) {
            return "NOT_ACCOUNT";
        }
    }

    public static String getUserRole(String token) {
        try {
            String sql = "SELECT user_role FROM users_token WHERE token = ?";
            Map<String, Object> result = jdbcTemplate2.queryForMap(sql, new Object[]{token});
            String role = (String) result.get("user_role");
            return role;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> selectAll() {
        final String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String account = resultSet.getString("account");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String create_time = resultSet.getString("create_time");
            int user_id = resultSet.getInt("userid");
            return new User(id, user_id, account, password, email, create_time, name);
        });
    }

    private int hasField(String sql, Object args) {
        try{
            RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
            jdbcTemplate.query(sql, new ArgumentPreparedStatementSetter(new Object[]{args}), countCallback);
            if (countCallback.getColumnCount() > 0) {
                return 1;
            } else {
                return 0;
            }
        }catch(Exception e){
            return 2;
        }
    }

    @Override
    public int checkAccount(String account) {
        String sql = "SELECT id FROM users WHERE account = ?";
        return hasField(sql,account);
    }

    @Override
    public int checkEmail(String email) {
        String sql = "SELECT id FROM users WHERE email = ?";
        return hasField(sql,email);
    }

    @Override
    public String newUser(UUID id, String create_time, User U) {
        String sql = "insert into users (id,account,password,email,name , create_time) values (?,?,?,?,?,?)  RETURNING userid";
        String account = U.getAccount();
        String password = U.getPassword();
        String email = U.getEmail();
        String userName = U.getName();
        if (userName == null || userName.equals("")) {
            userName = account;
        }
        Map<String, Object> result = jdbcTemplate.queryForMap(sql, id, account, password, email, userName, create_time);

        Integer mewUserId = (Integer) result.get("userid");
        String sql2 = "insert into users_token (token,user_role,userId,create_time) values (?,?,?,?)";
        String currentTime = getCurrentTime();
        String token = newUserToken();
        boolean r =  jdbcTemplate.update(sql2, token, "ROLE_USER", mewUserId, currentTime) > 0;
        if(r){
            return token;
        }else{
            return "wrong";
        }

    }

    private String newUserToken() {
        String tokenRaw = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder tokenA = new StringBuilder();
        for (var i = 0; i < 16; i++) {
            int number = (int) (Math.random() * 62);
            tokenA.append(tokenRaw.charAt(number));
        }
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DATE);
        return tokenA.toString() + year + month + day;
    }

}

