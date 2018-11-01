package com.codeup.springblog.controllers;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {


    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, length = 500)
    private String body;

    /**
     *|^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^|
     *|This mapping is equivalent to the following MySQL table definition:|
     *|                                                                   |
     *| CREATE TABLE ads (                                                |
     *|    id BIGINT NOT NULL AUTO_INCREMENT,                             |
     *|    title VARCHAR(100) NOT NULL,                                   |
     *|    description VARCHAR(255) NOT NULL,                             |
     *|    PRIMARY KEY (id)                                               |
     *|);                                                                 |
     *^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */



    public Post(String title,String body,long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public Post(String title,String body) {
        this.title = title;
        this.body = body;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
