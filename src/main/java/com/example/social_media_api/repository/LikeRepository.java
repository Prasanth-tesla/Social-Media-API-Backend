package com.example.social_media_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.social_media_api.entity.Like;
import com.example.social_media_api.entity.LikeId;

public interface LikeRepository extends JpaRepository<Like, LikeId> {
    @Query("SELECT l FROM Like l WHERE l.id.userId = :userId")
    List<Like> findLikesByUserId(@Param("userId") long userId);
}