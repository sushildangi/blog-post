package com.luv2tech.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginPayload {
    private String username;
    private String password;
}
