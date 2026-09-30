package com.example.social_media_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.social_media_api.dto.LikeResponse;
import com.example.social_media_api.entity.Like;
import com.example.social_media_api.entity.LikeId;

public interface LikeRepository extends JpaRepository<Like, LikeId> {

    @Query("""
    SELECT new com.example.social_media_api.dto.LikeResponse(
            l.createdAt,
            p
        )
        FROM Like l
        JOIN Post p ON p.postId = l.id.postId
        WHERE l.id.userId = :userId
    """)
    List<LikeResponse> findLikeResponsesByUserId(
            @Param("userId") long userId
    );
    
    @Query("SELECT l FROM Like l WHERE l.id.userId = :userId")
    List<Like> findLikesByUserId(@Param("userId") long userId);
}