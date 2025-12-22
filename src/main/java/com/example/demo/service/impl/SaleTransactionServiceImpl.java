package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository repo;

    public SaleTransactionServiceImpl(SaleTransactionRepository repo) {
        this.repo = repo;
    }

    @Override
    public SaleTransaction logTransaction(SaleTransaction transaction) {
        return repo.save(transaction);
    }

    @Override
    public SaleTransaction getTransactionById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long codeId) {
        return repo.findByDiscountCode_Id(codeId);
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return repo.findByDiscountCode_Influencer_Id(influencerId);
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return repo.findByDiscountCode_Campaign_Id(campaignId);
    }
}
