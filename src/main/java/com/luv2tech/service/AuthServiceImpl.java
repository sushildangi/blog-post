package com.luv2tech.service;

import com.luv2tech.exception.SpringBlogException;
import com.luv2tech.model.Role;
import com.luv2tech.model.User;
import com.luv2tech.payload.LoginPayload;
import com.luv2tech.payload.RegisterPayload;
import com.luv2tech.repository.RoleRepository;
import com.luv2tech.repository.UserRepository;
import com.luv2tech.response.AuthenticationResponse;
import com.luv2tech.security.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Override
    public ResponseEntity<?> signUp(RegisterPayload payload) {
        User user = new User();
        Set<Role> roles = user.getRoles();
        user.setUsername(payload.getUsername());
        user.setEmail(payload.getEmail());
        user.setPassword(encodePassword(payload.getPassword()));
        user.setName(payload.getName());
        for (String roleId : payload.getRoles()) {
            Role role = roleRepository.findById(roleId).orElseThrow(() -> new SpringBlogException("Invalid Role Id :" + roleId));
            roles.add(role);
        }

        userRepository.save(user);
        return new ResponseEntity<>("User Created", HttpStatus.CREATED);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public ResponseEntity<?> login(LoginPayload payload) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(payload.getUsername(),
                        payload.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authenticationToken = jwtProvider.generateToken(authenticate);
        AuthenticationResponse response = new AuthenticationResponse(authenticationToken, payload.getUsername());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
