package com.example.demo.service;

import com.example.demo.model.RoiReport;
import java.util.List;

public interface RoiService {

    RoiReport save(RoiReport report);

    List<RoiReport> findAll();

    RoiReport findById(Long id);

    void delete(Long id);
}
