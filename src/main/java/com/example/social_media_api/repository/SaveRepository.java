package com.example.social_media_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.social_media_api.dto.SaveResponse;
import com.example.social_media_api.entity.Save;
import com.example.social_media_api.entity.SaveId;

public interface SaveRepository extends JpaRepository<Save, SaveId> {
    @Query("""
        SELECT new com.example.social_media_api.dto.SaveResponse(
            s.createdAt,
            p
        )
        FROM Save s
        JOIN Post p ON p.postId = s.id.postId
        WHERE s.id.userId = :userId
    """)
    List<SaveResponse> findSaveResponsesByUserId(
            @Param("userId") long userId
    );
}