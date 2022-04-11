package com.analogfilm.photolab.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Scan")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Scan {
    @Id
    private String scan_machine;
    private double megapixels;
    private double prise;

//    @OneToMany(mappedBy="scan")
//    private Set<Film> Films;
}
