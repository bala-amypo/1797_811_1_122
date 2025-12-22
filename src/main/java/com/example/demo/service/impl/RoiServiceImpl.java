package com.example.demo.service.impl;

import com.example.demo.model.RoiReport;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    private final RoiReportRepository repository;

    public RoiServiceImpl(RoiReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoiReport save(RoiReport report) {
        return repository.save(report);
    }

    @Override
    public List<RoiReport> findAll() {
        return repository.findAll();
    }

    @Override
    public RoiReport findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
