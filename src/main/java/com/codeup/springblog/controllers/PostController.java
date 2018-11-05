package com.codeup.springblog.controllers;

;
import com.codeup.springblog.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    public String postId(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postService.findOne(id));

//    public String postId(@PathVariable String id, Model vModle) {
//        vModle.addAttribute("post", new Post("My first post", "It's about things!"));
        return "/posts/show";
    }
//    This allows the post to be created
    @GetMapping("/posts/create")
    public String showPost(Model vModel) {
        vModel.addAttribute("post", new Post());

        return "posts/create";
    }

//    Once the Post is created, this code allows it to be saved and viewed at once.
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        Post savePost = postService.updateOrSave(post);
        return "redirect:/posts/" + savePost.getId();
    }

//    This will allow me to update the add selected.
    @GetMapping("/posts/{id}/update")
    public String showPostUpdate(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/update";
    }

    @PostMapping("/posts/{id}/update")
    public String showUpdate(@ModelAttribute Post post){
        Post updatePost = postService.updateOrSave(post);
        return "redirect:/posts/" + updatePost.getId();
    }

   @PostMapping("/posts/{id}/delete")
    public String rmPost(@PathVariable long id){
        postService.deletePost(id);
        return "redirect:/posts/";
   }
}



