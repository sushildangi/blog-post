package com.luv2tech.post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/post")
public class PostController {

    @PostMapping
    public String test() {
        return "Hello Sushil";
    }
}
