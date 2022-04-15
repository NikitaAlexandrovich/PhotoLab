package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.models.Technology;
import com.analogfilm.photolab.repository.ScanRepository;
import com.analogfilm.photolab.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {
    private final TechnologyRepository techRepository;

    @Autowired
    public TechnologyService(TechnologyRepository techRepository) {
        this.techRepository = techRepository;
    }

    public List<Technology> findAll() {
        return techRepository.findAll();
    }
}
