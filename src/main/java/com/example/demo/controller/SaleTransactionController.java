package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public SaleTransaction create(@RequestBody SaleTransaction transaction) {
        return service.save(transaction);
    }

    // READ ALL
    @GetMapping
    public List<SaleTransaction> getAll() {
        return service.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public SaleTransaction getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
