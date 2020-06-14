package com.luv2tech.post.service;

import com.luv2tech.post.payload.BlogPostPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface BlogPostService {
    ResponseEntity<?> createBlogPost(BlogPostPayload payload, BindingResult result);
}
