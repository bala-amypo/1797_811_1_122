package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final List<DiscountCode> codes = new ArrayList<>();

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return codes.stream()
                .filter(c -> c.getId() != null && c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Discount code not found"));
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode code) {
        code.setId(id);
        codes.add(code);
        return code;
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return codes.stream()
                .filter(c -> c.getInfluencer() != null &&
                        c.getInfluencer().getId() != null &&
                        c.getInfluencer().getId().equals(influencerId))
                .collect(Collectors.toList());
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return codes.stream()
                .filter(c -> c.getCampaign() != null &&
                        c.getCampaign().getId() != null &&
                        c.getCampaign().getId().equals(campaignId))
                .collect(Collectors.toList());
    }
}
