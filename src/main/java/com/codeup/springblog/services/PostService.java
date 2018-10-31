package com.codeup.springblog.services;


import com.codeup.springblog.controllers.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {

    private List<Post> posts;

    public PostService(){
        posts = new ArrayList<>();

        //calls the method to make the new posts.
        createPosts();
    }

    public Post findOne(int id) {
        return posts.get(id - 1);
    }

    public List<Post> findAll(){
        return posts;


    }
    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    private void createPosts() {
        this.save(new Post("Halloween", "Dressed for fun", 1));
        this.save(new Post("Harry Potter", "Ravenclaw", 2));
        this.save(new Post("Clowns", "Super Spooky", 3));

    }

}
