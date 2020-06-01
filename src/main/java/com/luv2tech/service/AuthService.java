package com.luv2tech.service;

import com.luv2tech.payload.LoginPayload;
import com.luv2tech.payload.RegisterPayload;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> signUp(RegisterPayload payload);

    ResponseEntity<?> login(LoginPayload payload);
}
