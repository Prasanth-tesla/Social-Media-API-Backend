package com.example.social_media_api.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "users")
public class User {
    
    @Id
    private long userId;

    private String userName;

    private LocalDate dateOfBirth;

    private String gender;

    private String email;

    private String password;

    @Column(name = "follower_count", insertable = false, updatable = false)
    private Integer followerCount;

    @Column(name = "following_count", insertable = false, updatable = false)
    private Integer followingCount;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDate createdAt;

    public User() {
    }

    // getters

    public long getUserId() { return userId; }

    public String getUserName() { return userName; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public String getGender() { return gender; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public Integer getFollowerCount() { return followerCount; }

    public Integer getFollowingCount() { return followingCount; }

    public LocalDate getCreatedAt() { return createdAt; }

    // setters

    public void setUserId(long userId) { this.userId = userId; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public void setGender(String gender) { this.gender = gender; }

    public void setEmail(String email) { this.email = email; }

    public void setPassword(String password) { this.password = password; }

    public void setFollowerCount(Integer followerCount) { this.followerCount = followerCount; }

    public void setFollowingCount(Integer followingCount) { this.followingCount = followingCount; }

    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

}