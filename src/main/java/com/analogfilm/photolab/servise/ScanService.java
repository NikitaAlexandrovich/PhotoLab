package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.repository.ScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScanService {

    private final ScanRepository scanRepository;

    @Autowired
    public ScanService(ScanRepository scanRepository) {
        this.scanRepository = scanRepository;
    }

    public List<Scan> findAll() {
        return scanRepository.findAll();
    }
}
