package com.pweb.reddits.controller;

import com.pweb.reddits.entity.Post;
import com.pweb.reddits.entity.User;
import com.pweb.reddits.service.PostService;
import com.pweb.reddits.service.UserService;
import com.pweb.reddits.util.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
        Post post = new Post();
        for (Post p : postService.findAll()) {
            if (p.getSlug().equals(slug)) {
                post = p;
            }
        }

        model.addAttribute("post", post);
        model.addAttribute("title", post.getText());

        return "post";
    }

    @PostMapping("/post/new")
    public String postNew(Post post) {
        post.setSlug(Slugify.slugify(post.getText()));
        System.out.println(post.getSlug());

        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy 'at' h:mm a");
        post.setTimestamp(sdf.format(new Timestamp(System.currentTimeMillis())));

        postService.add(post);

        return "redirect:/";
    }

    @PostMapping("/post/delete/{id}")
    public String postDelete(@PathVariable("id") Long id) {
        postService.removeById(id);

        return "redirect:/";
    }

    @GetMapping("/post/edit/{id}")
    public String postEditPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("title", "Edit Post");
        model.addAttribute("post", postService.findById(id));

        return "editpost";
    }

    @PostMapping("/post/update")
    public String postSave(Post post) {
        postService.update(post);

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