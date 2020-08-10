package com.luv2tech.post.service;

import com.luv2tech.post.model.BlogPost;
import com.luv2tech.post.payload.BlogPostPayload;
import com.luv2tech.post.repository.BlogPostRepository;
import com.luv2tech.post.response.BlogResponse;
import com.luv2tech.util.service.ErrorCollector;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
@AllArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final ErrorCollector errorCollector;
    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<?> createBlogPost(BlogPostPayload payload,
                                            BindingResult result) {
        ResponseEntity<?> responseEntity;
        if (result.hasErrors()) {
            responseEntity = errorCollector.getErrorResponsesEntity(result);
        } else {
            BlogPost blogPost = modelMapper.map(payload, BlogPost.class);
            blogPostRepository.saveAndFlush(blogPost);
            responseEntity = ResponseEntity.
                    status(HttpStatus.CREATED)
                    .body(new BlogResponse(true,
                            "Blog Post Created Successfully, ID : " + blogPost.getId()));
        }
        return responseEntity;
    }
}
