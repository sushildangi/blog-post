package com.luv2tech.post.controller;

import com.luv2tech.post.payload.BlogPostPayload;
import com.luv2tech.post.service.BlogPostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/post")
@AllArgsConstructor
public class PostController {
    private final BlogPostService blogPostService;

    @PostMapping
    @PreAuthorize("hasAuthority('USER1')")
    public ResponseEntity<?> createBlogPost(@Valid @RequestBody BlogPostPayload payload,
                                            BindingResult result) {
        return blogPostService.createBlogPost(payload, result);
    }
}
