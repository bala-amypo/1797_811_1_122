package com.example.demo.service.impl;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final List<Campaign> campaigns = new ArrayList<>();

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {
        if (campaign.getStartDate() != null && campaign.getEndDate() != null &&
                campaign.getEndDate().isBefore(campaign.getStartDate())) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }
        campaign.setId(id);
        campaigns.add(campaign);
        return campaign;
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return campaigns.stream()
                .filter(c -> c.getId() != null && c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaigns;
    }
}
