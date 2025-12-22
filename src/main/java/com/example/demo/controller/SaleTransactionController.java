package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@Tag(name = "Sales Transactions")
public class SaleTransactionController {

    private final SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public SaleTransaction logSale(@RequestBody SaleTransaction transaction) {
        return service.logTransaction(transaction);
    }

    @GetMapping("/{id}")
    public SaleTransaction getById(@PathVariable Long id) {
        return service.getTransactionById(id);
    }

    @GetMapping("/code/{codeId}")
    public List<SaleTransaction> getByCode(@PathVariable Long codeId) {
        return service.getSalesForCode(codeId);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<SaleTransaction> getByInfluencer(@PathVariable Long influencerId) {
        return service.getSalesForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<SaleTransaction> getByCampaign(@PathVariable Long campaignId) {
        return service.getSalesForCampaign(campaignId);
    }
}
