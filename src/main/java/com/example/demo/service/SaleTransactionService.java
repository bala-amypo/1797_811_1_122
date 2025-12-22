package com.example.demo.service;

import com.example.demo.model.SaleTransaction;
import java.util.List;

public interface SaleTransactionService {

    SaleTransaction save(SaleTransaction transaction);

    List<SaleTransaction> findAll();

    SaleTransaction findById(Long id);

    void delete(Long id);
}
