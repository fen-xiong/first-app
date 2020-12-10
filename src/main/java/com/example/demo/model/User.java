package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private UUID id;
    private String account;
    private String password;
    private String email;
    private String name;
    public User(
            @JsonProperty("id") UUID id,
            @JsonProperty("account") String account,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email ,
            @JsonProperty("name") String name) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.email = email;
        this.name = name;
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

    public String getEimal() {
        return email;
    }

    public String getName() {
        return name;
    }
}

