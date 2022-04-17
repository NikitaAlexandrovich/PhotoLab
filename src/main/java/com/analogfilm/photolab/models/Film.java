package com.analogfilm.photolab.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name="Film")
public class Film {
    @Id
    private String name_film;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tech_name", referencedColumnName = "tech_name")
    private Technology tech_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scan_machine", referencedColumnName = "scan_machine")
    private Scan scan_machine;

    private double film_prise;
    private String format_type;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="tech_name", nullable=false)
//    private Technology technology;
//
//    @ManyToOne
//    @JoinColumn(name="scan_machine", nullable=false)
//    private Scan scan;
//
//    @OneToMany(mappedBy = "film")
//    private Set<Order> orders;

}
