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
            f.created_at,
            u.user_id,
            u.user_name,
            u.follower_count,
            u.following_count,
            u.post_count,
            u.created_at
        FROM followers f
        JOIN users u
            ON u.user_id = f.follower_id
        WHERE f.following_id = :userId
        ORDER BY f.created_at
        """, nativeQuery = true)
    List<Object[]> findFollowersByUserId(
            @Param("userId") long userId
    );

    @Query(value = """
        SELECT
            f.created_at,
            u.user_id,
            u.user_name,
            u.follower_count,
            u.following_count,
            u.post_count,
            u.created_at
        FROM followers f
        JOIN users u
            ON u.user_id = f.following_id
        WHERE f.follower_id = :userId
        ORDER BY f.created_at
        """, nativeQuery = true)
    List<Object[]> findFollowingByUserId(
            @Param("userId") long userId
    );
}