package com.luv2tech.post.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
public class BlogPostPayload {
    @NotBlank(message = "Title is required!")
    private String title;
    @NotBlank(message = "Content is required!")
    private String content;
}
