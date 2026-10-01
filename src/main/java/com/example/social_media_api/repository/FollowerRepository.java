package com.example.social_media_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.social_media_api.entity.Follower;
import com.example.social_media_api.entity.FollowerId;

public interface FollowerRepository
        extends JpaRepository<Follower, FollowerId> {

    @Query(value = """
    SELECT
        u.user_id,
        u.user_name
    FROM users u
    JOIN followers f
        ON u.user_id = f.follower_id
    WHERE f.following_id = :userId
    ORDER BY f.created_at
    """, nativeQuery = true)
    List<Object[]> findFollowersByUserId(
            @Param("userId") long userId
    );

    @Query(value = """
    SELECT
        u.user_id,
        u.user_name
    FROM users u
    JOIN followers f
        ON u.user_id = f.following_id
    WHERE f.follower_id = :userId
    ORDER BY f.created_at
    """, nativeQuery = true)
    List<Object[]> findFollowingByUserId(
            @Param("userId") long userId
    );
}