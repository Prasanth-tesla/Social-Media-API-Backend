package com.example.social_media_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social_media_api.entity.User;
import com.example.social_media_api.repository.UserRepository;

@Service 
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findByUserName(name);
    }

    public List<User> getUsersByGender(String gender) {
        return userRepository.findByGender(gender);
    }

    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        userRepository.flush();
        return userRepository.findById(savedUser.getUserId()).orElseThrow();
    }

    public User updateUserName(long userId, String userName) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                    new RuntimeException("User not found"));

        user.setUserName(userName);

        return userRepository.save(user);
    }
}
