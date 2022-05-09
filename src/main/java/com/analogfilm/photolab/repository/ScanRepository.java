package com.analogfilm.photolab.repository;

import com.analogfilm.photolab.models.Scan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ScanRepository extends JpaRepository<Scan, String> {
//    @Modifying
//    @Query(value = "DELETE t.* FROM FilmLab.`Scan` t WHERE t.scan_machine = ?1", nativeQuery = true)
//    @Transactional
//    void deleteByName(String nameScan);
}
