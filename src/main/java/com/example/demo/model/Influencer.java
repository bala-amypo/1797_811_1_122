package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class Influencer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private String socialHandle;

    private String email;
    private Boolean active = true;

    private Timestamp createdAt;

    @PrePersist
    void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    // getters & setters
}
