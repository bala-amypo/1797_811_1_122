package com.example.demo.service.impl;

import com.example.demo.model.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository repository;

    public CampaignServiceImpl(CampaignRepository repository) {
        this.repository = repository;
    }

    @Override
    public Campaign save(Campaign campaign) {
        return repository.save(campaign);
    }

    @Override
    public List<Campaign> findAll() {
        return repository.findAll();
    }

    @Override
    public Campaign findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
