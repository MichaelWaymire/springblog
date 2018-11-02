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

    public user(String username,String password,String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }




}
