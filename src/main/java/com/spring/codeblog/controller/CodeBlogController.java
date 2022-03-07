package com.spring.codeblog.controller;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CodeBlogController {

    @Autowired
    CodeBlogService codeBlogService;

    @GetMapping(value = "/posts")
    public ModelAndView getPosts() {
        ModelAndView modelAndView = new ModelAndView("posts");
        List<Post> postList = codeBlogService.findAll();
        modelAndView.addObject("posts", postList);
        return modelAndView;
    }

    @GetMapping(value = "/posts/{id}")
    public ModelAndView getPostDetails(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("postDetails");
        Post post = codeBlogService.findById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @GetMapping(value = "/newpost")
    public String getPostForm() {
        return "postForm";
    }

    @PostMapping(value = "/newpost")
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "redirect:/newpost";
        }
        post.setCreatedAt(LocalDate.now());
        Post savePost = codeBlogService.save(post);
        return "redirect:/posts";
    }
}
