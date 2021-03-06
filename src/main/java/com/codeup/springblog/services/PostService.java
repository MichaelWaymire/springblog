package com.codeup.springblog.services;


import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {
//    Creates a list called Post
    private List<Post> posts;



    private PostRepo postRepo;


    public PostService(PostRepo postRepo){
        this.postRepo = postRepo;
    }

    public Iterable<Post> findAll() {
        // All the ads from DB
        return postRepo.findAll();
    }
//    Allows us to find a single  post
    public Post findOne(long id) {

        return postRepo.findOne(id);
    }
//    Allows us to update the add as needed
    public Post updateOrSave(Post post){
        return postRepo.save(post);
    }

    //deletes selected post
    public void deletePost(long id) { postRepo.delete(id); }

    }


