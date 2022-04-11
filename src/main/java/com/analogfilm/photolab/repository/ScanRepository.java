package com.analogfilm.photolab.repositoty;

import com.analogfilm.photolab.models.Scan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScanRepository extends JpaRepository<Scan, String> {
}
