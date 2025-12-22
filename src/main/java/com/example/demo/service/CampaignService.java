package com.example.demo.service;

import com.example.demo.model.Campaign;
import java.util.List;

public interface CampaignService {

    Campaign save(Campaign campaign);

    List<Campaign> findAll();

    Campaign findById(Long id);

    void delete(Long id);
}
