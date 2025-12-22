package com.example.demo.service.impl;

import com.example.demo.model.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository repo;

    public CampaignServiceImpl(CampaignRepository repo) {
        this.repo = repo;
    }

    @Override
    public Campaign createCampaign(Campaign campaign) {
        return repo.save(campaign);
    }

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {
        Campaign existing = getCampaignById(id);
        existing.setCampaignName(campaign.getCampaignName());
        existing.setStartDate(campaign.getStartDate());
        existing.setEndDate(campaign.getEndDate());
        existing.setBudget(campaign.getBudget());
        return repo.save(existing);
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return repo.findAll();
    }

    @Override
    public void deactivateCampaign(Long id) {
        Campaign campaign = getCampaignById(id);
        campaign.setActive(false);
        repo.save(campaign);
    }
}
