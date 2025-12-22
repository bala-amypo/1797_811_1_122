package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository repository;

    public SaleTransactionServiceImpl(SaleTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public SaleTransaction save(SaleTransaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public List<SaleTransaction> findAll() {
        return repository.findAll();
    }

    @Override
    public SaleTransaction findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
