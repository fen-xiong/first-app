package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private UUID id;
    private String account;
    private String password;
    private String email;
    private String name;
    private String create_time;
    private int user_id;
    public User(
            @JsonProperty("id") UUID id,
            @JsonProperty("create_time") int userid ,
            @JsonProperty("account") String account,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email ,
            @JsonProperty("create_time") String create_time ,
            @JsonProperty("name") String name) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.email = email;
        this.name = name;
        this.create_time = create_time;
        this.user_id = userid;
    }

    public UUID getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCreate_time() {
        return create_time;
    }
    public int getUser_id() {
        return user_id;
    }
}

