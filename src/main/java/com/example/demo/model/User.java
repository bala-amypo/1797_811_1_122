package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;
    private String role = "MARKETER";
    private LocalDateTime createdAt = LocalDateTime.now();

    // getters & setters
}
