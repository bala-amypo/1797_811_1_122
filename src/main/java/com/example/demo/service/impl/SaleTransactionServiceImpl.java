package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Override
    public SaleTransaction createSale(SaleTransaction tx) {
        if (tx.getTransactionAmount() == null ||
            tx.getTransactionAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }

        tx.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        return tx;
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long codeId) {
        return Collections.emptyList();
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return Collections.emptyList();
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return Collections.emptyList();
    }
}
