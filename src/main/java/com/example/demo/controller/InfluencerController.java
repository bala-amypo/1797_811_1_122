package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InfluencerController {

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    @PostMapping("/influencers")
    public ResponseEntity<Influencer> createInfluencer(@RequestBody Influencer influencer) {
        return ResponseEntity.ok(influencerService.createInfluencer(influencer));
    }

    @GetMapping("/influencers")
    public ResponseEntity<List<Influencer>> getAllInfluencers() {
        return ResponseEntity.ok(influencerService.getAllInfluencers());
    }

    @GetMapping("/influencers/{id}")
    public ResponseEntity<Influencer> getInfluencer(@PathVariable Long id) {
        return ResponseEntity.ok(influencerService.getInfluencerById(id));
    }
}
