package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final List<Influencer> influencers = new ArrayList<>();

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        if (influencer.getSocialHandle() == null || influencer.getSocialHandle().isEmpty()) {
            throw new IllegalArgumentException("Social handle is required");
        }
        influencers.add(influencer);
        return influencer;
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return influencers;
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return influencers.stream()
                .filter(i -> i.getId() != null && i.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Influencer not found"));
    }
}
