package com.luv2tech.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ApiResponse {

    private String timestamp;
    private HttpStatus status;
    private Boolean success;
    private String message;
    private String path;
    private String error;


}
