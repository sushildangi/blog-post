package com.luv2tech.post.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class BlogResponse {
    private Boolean success;
    private String message;
}
