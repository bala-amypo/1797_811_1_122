package com.example.demo.controller;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roi-reports")
public class RoiReportController {

    private final RoiService service;

    public RoiReportController(RoiService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public RoiReport create(@RequestBody RoiReport report) {
        return service.save(report);
    }

    // READ ALL
    @GetMapping
    public List<RoiReport> getAll() {
        return service.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public RoiReport getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
