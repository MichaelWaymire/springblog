package com.codeup.springblog.services;


import com.codeup.springblog.controllers.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {
//    Creates a list called Post
    private List<Post> posts;


    public PostService(){
        posts = new ArrayList<>();

        //calls the method to make the new posts.
        createPosts();
    }
//    Allows us to find a single  post
    public Post findOne(int id) {
        return posts.get(id - 1);
    }
//    Allows us to update the add as needed
    public Post update(Post post){
        return posts.set(post.getId() - 1, post);
    }

//    Allows us to find all the posts
    public List<Post> findAll(){
        return posts;


    }
//    Be able to save the posts to the list
    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }
//    Create the ads (non-database)
    private void createPosts() {
        this.save(new Post("Halloween", "Dressed for fun"));
        this.save(new Post("Harry Potter", "Ravenclaw"));
        this.save(new Post("Clowns", "Super Spooky"));

    }

}
