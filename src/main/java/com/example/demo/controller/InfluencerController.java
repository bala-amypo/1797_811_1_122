package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/influencers")
public class InfluencerController {

    private final InfluencerService service;

    public InfluencerController(InfluencerService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Influencer create(@RequestBody Influencer influencer) {
        return service.save(influencer);
    }

    // READ ALL
    @GetMapping
    public List<Influencer> getAll() {
        return service.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Influencer getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
