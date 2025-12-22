package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public DiscountCode create(@RequestBody DiscountCode code) {
        return service.save(code);
    }

    // READ ALL
    @GetMapping
    public List<DiscountCode> getAll() {
        return service.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public DiscountCode getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
