package com.analogfilm.photolab.repository;

import com.analogfilm.photolab.models.Scan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScanRepository extends JpaRepository<Scan, String> {
}
