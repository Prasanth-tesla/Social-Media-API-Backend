package com.example.social_media_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.social_media_api.dto.AuthResponse;
import com.example.social_media_api.dto.LoginRequest;
import com.example.social_media_api.dto.LoginResponse;
import com.example.social_media_api.dto.RegisterRequest;
import com.example.social_media_api.entity.User;
import com.example.social_media_api.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request) {

        User user = authService.register(request);

        AuthResponse response = new AuthResponse(
                user.getUserId(),
                user.getUserName(),
                user.getEmail()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request) {

        String token = authService.login(request);

        if (token == null) {
            return ResponseEntity
                    .status(401)
                    .body("Invalid email or password");
        }

        return ResponseEntity.ok(
                new LoginResponse(token)
        );
    }
}