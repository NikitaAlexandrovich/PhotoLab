package com.analogfilm.photolab.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Film")
public class Film {
    @Id
    private String name_film;
    private String tech_name;
    private String scan_machine;
    private double film_prise;
    private String format_type;

    @ManyToOne
    @JoinColumn(name="tech_name", nullable=false)
    private Technology technology;

    @ManyToOne
    @JoinColumn(name="scan_machine", nullable=false)
    private Scan scan;

    public Film() {}
}
