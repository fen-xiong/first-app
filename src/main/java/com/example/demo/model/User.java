package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private UUID id;
    private String account;
    private String password;
    private String eimal;
    private String name;
    public User(
            @JsonProperty("id") UUID id,
            @JsonProperty("account") String account,
            @JsonProperty("password") String password,
            @JsonProperty("eimal") String eimal ,
            @JsonProperty("name") String name) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.eimal = eimal;
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
        return eimal;
    }

    public String getName() {
        return name;
    }
}

