package com.example.social_media_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.social_media_api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserName(String userName);

    List<User> findByGender(String gender);

    @Modifying
    @Query("""
        UPDATE User u
        SET u.followingCount = u.followingCount + 1
        WHERE u.userId = :userId
    """)
    void incrementFollowingCount(@Param("userId") long userId);

    @Modifying
    @Query("""
        UPDATE User u
        SET u.followerCount = u.followerCount + 1
        WHERE u.userId = :userId
    """)
    void incrementFollowerCount(@Param("userId") long userId);
    
    @Modifying
    @Query("""
        UPDATE User u
        SET u.followingCount = u.followingCount - 1
        WHERE u.userId = :userId
    """)
    void decrementFollowingCount(@Param("userId") long userId);

    @Modifying
    @Query("""
        UPDATE User u
        SET u.followerCount = u.followerCount - 1
        WHERE u.userId = :userId
    """)
    void decrementFollowerCount(@Param("userId") long userId);
}
