package com.example.demo.service.impl;

import com.example.demo.model.RoiReport;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    private final RoiReportRepository roiRepo;
    private final SaleTransactionRepository saleRepo;
    private final DiscountCodeRepository codeRepo;

    public RoiServiceImpl(
            RoiReportRepository roiRepo,
            SaleTransactionRepository saleRepo,
            DiscountCodeRepository codeRepo) {
        this.roiRepo = roiRepo;
        this.saleRepo = saleRepo;
        this.codeRepo = codeRepo;
    }

    @Override
    public RoiReport generateRoiForCode(Long codeId) {
        var code = codeRepo.findById(codeId)
                .orElseThrow(() -> new RuntimeException("Code not found"));

        BigDecimal total = saleRepo.findByDiscountCode_Id(codeId)
                .stream()
                .map(SaleTransaction::getSaleAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        RoiReport report = new RoiReport();
        report.setInfluencer(code.getInfluencer());
        report.setCampaign(code.getCampaign());
        report.setTotalSales(total);
        report.setTotalRevenue(total);
        report.setRoiPercentage(BigDecimal.valueOf(100));

        return roiRepo.save(report);
    }

    @Override
    public RoiReport getReportById(Long id) {
        return roiRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("ROI report not found"));
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiRepo.findAll().stream()
                .filter(r -> r.getInfluencer().getId().equals(influencerId))
                .toList();
    }

    @Override
    public List<RoiReport> getReportsForCampaign(Long campaignId) {
        return roiRepo.findByCampaign_Id(campaignId);
    }
}
