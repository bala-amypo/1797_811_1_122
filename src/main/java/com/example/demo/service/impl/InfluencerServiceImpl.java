package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final InfluencerRepository repository;

    public InfluencerServiceImpl(InfluencerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Influencer save(Influencer influencer) {
        return repository.save(influencer);
    }

    @Override
    public List<Influencer> findAll() {
        return repository.findAll();
    }

    @Override
    public Influencer findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
