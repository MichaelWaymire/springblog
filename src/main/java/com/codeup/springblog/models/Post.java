package com.codeup.springblog.models;



import javax.persistence.*;
import java.util.List;

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


//
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "User")
//    private List<Post> posts;


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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
