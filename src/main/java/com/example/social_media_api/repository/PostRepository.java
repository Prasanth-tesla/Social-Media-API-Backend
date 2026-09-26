package com.example.social_media_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.social_media_api.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    @Modifying
    @Query("""
        UPDATE Post p
        SET p.likeCount = p.likeCount + 1
        WHERE p.postId = :postId
    """)
    void incrementLikeCount(@Param("postId") long postId);
}