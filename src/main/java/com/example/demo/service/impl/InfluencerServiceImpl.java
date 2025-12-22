package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final InfluencerRepository repo;

    public InfluencerServiceImpl(InfluencerRepository repo) {
        this.repo = repo;
    }

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        return repo.save(influencer);
    }

    @Override
    public Influencer updateInfluencer(Long id, Influencer influencer) {
        Influencer existing = getInfluencerById(id);
        existing.setName(influencer.getName());
        existing.setEmail(influencer.getEmail());
        existing.setSocialHandle(influencer.getSocialHandle());
        return repo.save(existing);
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Influencer not found"));
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return repo.findAll();
    }

    @Override
    public void deactivateInfluencer(Long id) {
        Influencer influencer = getInfluencerById(id);
        influencer.setActive(false);
        repo.save(influencer);
    }
}
