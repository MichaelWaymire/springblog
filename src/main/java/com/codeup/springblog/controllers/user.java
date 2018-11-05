package com.codeup.springblog.controllers;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class user {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    public user() {
    }

    public user(long id, String username,String password,String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public user(String username,String password,String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
