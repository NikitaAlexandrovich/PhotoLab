package com.analogfilm.photolab.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name="Technology")
public class Technology {
    @Id
    private String tech_name;
    private double price;
    private int time_to_process;

    @OneToMany(mappedBy="technology")
    private Set<Film> Films;
}
