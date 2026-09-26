package com.example.social_media_api.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shares")
public class Share {

    @Id
    @Column(name = "share_id")
    private long shareId;

    @Column(name = "source_id")
    private long sourceId;

    @Column(name = "dest_id")
    private long destId;

    @Column(name = "post_id")
    private long postId;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDate createdAt;

    public Share() {
    }

    // getters
    public long getShareId() { return shareId; }

    public long getSourceId() { return sourceId; }

    public long getDestId() { return destId; }

    public long getPostId() { return postId; }

    public LocalDate getCreatedAt() { return createdAt; }

    // setters
    public void setShareId(long shareId) { this.shareId = shareId; }

    public void setSourceId(long sourceId) { this.sourceId = sourceId; }

    public void setDestId(long destId) { this.destId = destId; }

    public void setPostId(long postId) { this.postId = postId; }
    
}