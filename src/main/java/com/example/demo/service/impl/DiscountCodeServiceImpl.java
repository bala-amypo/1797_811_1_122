package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository repository;

    public DiscountCodeServiceImpl(DiscountCodeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiscountCode save(DiscountCode discountCode) {
        return repository.save(discountCode);
    }

    @Override
    public List<DiscountCode> findAll() {
        return repository.findAll();
    }

    @Override
    public DiscountCode findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
