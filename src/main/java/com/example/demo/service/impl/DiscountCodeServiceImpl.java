package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository codeRepo;
    private final InfluencerRepository influencerRepo;
    private final CampaignRepository campaignRepo;

    public DiscountCodeServiceImpl(
            DiscountCodeRepository codeRepo,
            InfluencerRepository influencerRepo,
            CampaignRepository campaignRepo) {
        this.codeRepo = codeRepo;
        this.influencerRepo = influencerRepo;
        this.campaignRepo = campaignRepo;
    }

    @Override
    public DiscountCode createDiscountCode(DiscountCode code) {
        return codeRepo.save(code);
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode code) {
        DiscountCode existing = getCodeById(id);
        existing.setCode(code.getCode());
        existing.setDiscountPercentage(code.getDiscountPercentage());
        return codeRepo.save(existing);
    }

    @Override
    public DiscountCode getCodeById(Long id) {
        return codeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Code not found"));
    }

    @Override
    public List<DiscountCode> getCodesByInfluencer(Long influencerId) {
        return codeRepo.findAll().stream()
                .filter(c -> c.getInfluencer().getId().equals(influencerId))
                .toList();
    }

    @Override
    public List<DiscountCode> getCodesByCampaign(Long campaignId) {
        return codeRepo.findAll().stream()
                .filter(c -> c.getCampaign().getId().equals(campaignId))
                .toList();
    }

    @Override
    public void deactivateCode(Long id) {
        DiscountCode code = getCodeById(id);
        code.setActive(false);
        codeRepo.save(code);
    }
}
