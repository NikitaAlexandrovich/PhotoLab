package com.analogfilm.photolab.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee{
    @Id
    @Column (name = "FIO")
    private String FIO;
    @Column (name = "experience")
    private int experience;
    @Column (name = "passphrase")
    private String passphrase;
}
