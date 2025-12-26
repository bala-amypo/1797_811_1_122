package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final List<SaleTransaction> transactions = new ArrayList<>();

    @Override
    public SaleTransaction createSale(SaleTransaction transaction) {
        if (transaction.getTransactionAmount() == null ||
                transaction.getTransactionAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }
        transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        transactions.add(transaction);
        return transaction;
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long codeId) {
        return transactions.stream()
                .filter(t -> t.getDiscountCode() != null &&
                        t.getDiscountCode().getId() != null &&
                        t.getDiscountCode().getId().equals(codeId))
                .collect(Collectors.toList());
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return transactions.stream()
                .filter(t -> t.getDiscountCode() != null &&
                        t.getDiscountCode().getInfluencer() != null &&
                        t.getDiscountCode().getInfluencer().getId() != null &&
                        t.getDiscountCode().getInfluencer().getId().equals(influencerId))
                .collect(Collectors.toList());
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return transactions.stream()
                .filter(t -> t.getDiscountCode() != null &&
                        t.getDiscountCode().getCampaign() != null &&
                        t.getDiscountCode().getCampaign().getId() != null &&
                        t.getDiscountCode().getCampaign().getId().equals(campaignId))
                .collect(Collectors.toList());
    }
}
