package com.luv2tech.controller;

import com.luv2tech.payload.LoginPayload;
import com.luv2tech.payload.RegisterPayload;
import com.luv2tech.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@RequestBody RegisterPayload payload) {
        return authService.signUp(payload);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginPayload payload) {
        return authService.login(payload);
    }
}
