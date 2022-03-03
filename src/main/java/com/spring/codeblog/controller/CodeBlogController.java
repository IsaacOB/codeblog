package com.spring.codeblog.controller;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
