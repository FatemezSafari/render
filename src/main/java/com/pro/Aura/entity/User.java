package com.pro.Aura.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users") // این annotation میگه اسم جدول تو دیتابیس "users" هست
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) // اینجا میگیم ایمیل باید منحصر به فرد و اجباری باشه
    private String email;

    @Column(name = "password_hash") // این annotation میگه اسم ستون توی دیتابیس "password_hash" هست
    private String passwordHash;

    @Column(name = "full_name")
    private String fullName;

    private String role = "USER"; // مقدار پیشفرض

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Constructors
    public User() {
    }

    public User(String email, String passwordHash, String fullName) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
        this.createdAt = LocalDateTime.now();
    }

    // Getter and Setter methods (همه رو باید داشته باشی)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}