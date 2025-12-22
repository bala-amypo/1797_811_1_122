package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/influencers")
@Tag(name = "Influencers")
public class InfluencerController {

    private final InfluencerService service;

    public InfluencerController(InfluencerService service) {
        this.service = service;
    }

    @PostMapping
    public Influencer create(@RequestBody Influencer influencer) {
        return service.createInfluencer(influencer);
    }

    @PutMapping("/{id}")
    public Influencer update(@PathVariable Long id, @RequestBody Influencer influencer) {
        return service.updateInfluencer(id, influencer);
    }

    @GetMapping("/{id}")
    public Influencer getById(@PathVariable Long id) {
        return service.getInfluencerById(id);
    }

    @GetMapping
    public List<Influencer> getAll() {
        return service.getAllInfluencers();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateInfluencer(id);
    }
}
