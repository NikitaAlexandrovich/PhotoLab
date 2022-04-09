package com.analogfilm.photolab.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Employee")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee{
    @Id
    private String FIO;
    @Column (name = "experience")
    private int experience;
    @Column (name = "passphrase")
    private String passphrase;
}
