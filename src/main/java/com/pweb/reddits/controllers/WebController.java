package com.pweb.reddits.controllers;

import com.pweb.reddits.entity.Post;
import com.pweb.reddits.entity.User;
import com.pweb.reddits.services.PostService;
import com.pweb.reddits.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class WebController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("posts", postService.findAll());

        return "index";
    }

    @GetMapping("/newpost")
    public String newPostPage(Model model) {
        model.addAttribute("title", "New Post");
        model.addAttribute("post", new Post());

        return "newpost";
    }

    @GetMapping("/post/{slug}")
    public String displayPostPage(@PathVariable("slug") String slug, Model model) {
        Post post = postService.findPostBySlug(slug);
        model.addAttribute("post", post);
        model.addAttribute("title", post.getText());

        return "post";
    }

    @PostMapping("/post/new")
    public String postNew(Post post) {
        postService.addPost(post);

        return "redirect:/";
    }

    @PostMapping("/post/edit")
    public String postEdit(Post post) {
        postService.addPost(post);

        return "redirect:/";
    }

    @PostMapping("/post/delete/{id}")
    public String postDelete(@PathVariable("id") long id) {
        postService.removePostById(id);

        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signUpPage(Model model) {
        model.addAttribute("title", "Sign Up");
        model.addAttribute("user", new User());

        return "signup";
    }

    @PostMapping("/user/signup")
    public String userSignUp(User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("title", "Sign Up");

        return "login";
    }

    @GetMapping("/profile")
    public String profilePage(Model model) {
        model.addAttribute("title", "Profile");

        return "profile";
    }

    @GetMapping("/changeprofile")
    public String changeProfilePage(Model model) {
        model.addAttribute("title", "Change Profile");

        return "changeprofile";
    }
}