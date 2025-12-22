package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String campaignName;

    private Date startDate;
    private Date endDate;

    private BigDecimal budget;
    private Boolean active = true;

    
}
