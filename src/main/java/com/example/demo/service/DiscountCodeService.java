package com.example.demo.service;

import com.example.demo.model.DiscountCode;
import java.util.List;

public interface DiscountCodeService {

    DiscountCode save(DiscountCode discountCode);

    List<DiscountCode> findAll();

    DiscountCode findById(Long id);

    void delete(Long id);
}
