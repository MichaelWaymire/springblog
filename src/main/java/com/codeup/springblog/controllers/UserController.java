package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.services.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepo users,PasswordEncoder passwordEncoder) {
        this.userRepo = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user",new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepo.save(user);
        return "redirect:/login";
    }

    @GetMapping("/users/{id}")
    public String showProfile(@PathVariable long id,Model model) {
        User user = userRepo.findOne(id);
        User loggedInUser = ( User ) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!user.getUsername().equals(loggedInUser.getUsername())) {
            return "redirect:/posts";
        }

        model.addAttribute("user",user);
        return "redirect:/posts/create";
    }
}

