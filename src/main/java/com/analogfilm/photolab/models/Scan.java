package com.analogfilm.photolab.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name="Scan")
public class Scan {
    @Id
    private String scan_machine;
    private double megapixels;
    private double prise;

    @OneToMany(mappedBy="scan")
    private Set<Film> Films;
}
