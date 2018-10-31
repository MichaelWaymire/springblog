package com.codeup.springblog.controllers;

;
import com.codeup.springblog.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }


    @GetMapping("/posts")
    public String postPage(Model vModel) {

        vModel.addAttribute("posts", postService.findAll());

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
//    This code is simaler to how a post would be pulled from a database
    public String postId(@PathVariable int id, Model viewModel) {
        viewModel.addAttribute("post", postService.findOne(id));

//    public String postId(@PathVariable String id, Model vModle) {
//        vModle.addAttribute("post", new Post("My first post", "It's about things!"));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a new post";
    }

    @PostMapping("/posts/create")
    public @ResponseBody
    ResponseEntity<String> post() {
        return new ResponseEntity<String>("POST Response", HttpStatus.OK);
    }


}
