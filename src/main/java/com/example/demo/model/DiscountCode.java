package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DiscountCode {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String code;

    @ManyToOne
    private Influencer influencer;

    @ManyToOne
    private Campaign campaign;

    private Double discountPercentage;
    private Boolean active = true;

    // getters & setters
}
