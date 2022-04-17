package com.analogfilm.photolab.repository;

import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.models.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, String> {
}
