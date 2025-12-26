package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository saleTransactionRepository;

    public SaleTransactionServiceImpl(SaleTransactionRepository saleTransactionRepository) {
        this.saleTransactionRepository = saleTransactionRepository;
    }

    @Override
    public SaleTransaction createSale(SaleTransaction transaction) {
        if (transaction.getTransactionAmount() == null ||
            transaction.getTransactionAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }

        transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        return saleTransactionRepository.save(transaction);
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long discountCodeId) {
        return saleTransactionRepository.findByDiscountCodeId(discountCodeId);
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        // handled via queries in real apps
        return List.of();
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        // handled via queries in real apps
        return List.of();
    }
}
