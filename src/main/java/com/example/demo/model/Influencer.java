package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "influencers")
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String socialHandle;

    private boolean active = true;

    // getters & setters
}
