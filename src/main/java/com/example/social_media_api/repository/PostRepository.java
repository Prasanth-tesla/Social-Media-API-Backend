package com.example.social_media_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.social_media_api.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

    List<Post> findByUserId(long userId);
    @Modifying
    @Query("""
        UPDATE Post p
        SET p.likeCount = p.likeCount + 1
        WHERE p.postId = :postId
    """)
    void incrementLikeCount(@Param("postId") long postId);

    @Modifying
    @Query("""
        UPDATE Post p
        SET p.shareCount = p.shareCount + 1
        WHERE p.postId = :postId
    """)
    void incrementShareCount(@Param("postId") long postId);

    @Modifying
    @Query("""
        UPDATE Post p
        SET p.saveCount = p.saveCount + 1
        WHERE p.postId = :postId
    """)
    void incrementSaveCount(@Param("postId") long postId);

    @Modifying
    @Query("""
        UPDATE Post p
        SET p.saveCount = p.saveCount - 1
        WHERE p.postId = :postId
    """)
    void decrementSaveCount(@Param("postId") long postId);

    @Modifying
    @Query("""
        UPDATE Post p
        SET p.likeCount = p.likeCount - 1
        WHERE p.postId = :postId
    """)
    void decrementLikeCount(@Param("postId") long postId);
}