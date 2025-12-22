package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sale_transactions")
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DiscountCode discountCode;

    private BigDecimal transactionAmount;
    private LocalDateTime transactionDate;
    private Long customerId;

    public SaleTransaction() {}

    public Long getId() { return id; }
    public DiscountCode getDiscountCode() { return discountCode; }
    public BigDecimal getTransactionAmount() { return transactionAmount; }
    public LocalDateTime getTransactionDate() { return transactionDate; }
    public Long getCustomerId() { return customerId; }

    public void setId(Long id) { this.id = id; }
    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
    public void setTransactionAmount(BigDecimal transactionAmount) { this.transactionAmount = transactionAmount; }
    public void setTransactionDate(LocalDateTime transactionDate) { this.transactionDate = transactionDate; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}
