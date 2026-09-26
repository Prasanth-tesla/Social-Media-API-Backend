package com.example.social_media_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.social_media_api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserName(String userName);

    List<User> findByGender(String gender);
}
