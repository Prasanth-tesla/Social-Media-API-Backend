package com.example.social_media_api.service;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.social_media_api.dto.LoginRequest;
import com.example.social_media_api.dto.RegisterRequest;
import com.example.social_media_api.entity.User;
import com.example.social_media_api.repository.UserRepository;

@Service
public class AuthService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public User register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setUserName(request.getUserName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setGender(request.getGender());
        user.setEmail(request.getEmail());

        user.setPassword(
            passwordEncoder.encode(request.getPassword())
        );

        return userRepository.save(user);
    }

    public String login(LoginRequest request) {

        Optional<User> user =
                userRepository.findByEmail(request.getEmail());

        if (user.isEmpty()) {
            return null;
        }

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.get().getPassword()
        );

        if (!matches) {
            return null;
        }

        return jwtService.generateToken(
                user.get().getUserId(),
                user.get().getEmail()
        );
    }
}