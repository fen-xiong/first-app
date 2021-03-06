package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userdao;

    @Autowired
    public UserService(@Qualifier("User") UserDao userdao) {
        this.userdao = userdao;
    }

    public String newUser(User user) {
        return userdao.newUser(user);
    }
    public List<User> selectAll() {
        return userdao.selectAll();
    }
    public int checkAccount(String account) {
        return userdao.checkAccount(account);
    }
    public int checkEmail(String email) {
        return userdao.checkEmail(email);
    }
    public String signIn(String account , String password) {
        return userdao.signIn(account,password);
    }
}
