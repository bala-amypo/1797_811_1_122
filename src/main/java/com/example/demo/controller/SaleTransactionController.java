package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    @PostMapping("/sales")
    public ResponseEntity<SaleTransaction> createSale(@RequestBody SaleTransaction transaction) {
        return ResponseEntity.ok(saleTransactionService.createSale(transaction));
    }

    @GetMapping("/sales/code/{codeId}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCode(@PathVariable Long codeId) {
        return ResponseEntity.ok(saleTransactionService.getSalesForCode(codeId));
    }
}
