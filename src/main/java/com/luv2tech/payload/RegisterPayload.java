package com.luv2tech.payload;

import com.luv2tech.model.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
public class RegisterPayload {
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();
}
