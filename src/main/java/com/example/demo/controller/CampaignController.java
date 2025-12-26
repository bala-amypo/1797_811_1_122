package com.example.demo.controller;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService service;

    public CampaignController(CampaignService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Campaign create(@RequestBody Campaign campaign) {
        return service.save(campaign);
    }

    // READ ALL
    @GetMapping
    public List<Campaign> getAll() {
        return service.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Campaign getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // UPDATE
    @UpdateMapping("/{id}")
    public void delete(@PathVariable long id){
        service.update(id);
    }
}
