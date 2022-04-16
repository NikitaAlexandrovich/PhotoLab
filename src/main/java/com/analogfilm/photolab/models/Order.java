package com.analogfilm.photolab.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Order")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="username", referencedColumnName = "username")
    private User username;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="employee_name", referencedColumnName = "username")
    private User employee_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="name_film", referencedColumnName = "name_film")
    private Film name_film;

    private boolean in_progress;
    private boolean need_develop;
    private boolean need_scan;
    private double order_cost;

//    @ManyToOne
//    @JoinColumn(name="username", nullable=false)
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name="employee_name", nullable=false)
//    private User employee;
//
//    @ManyToOne
//    @JoinColumn(name="name_film", nullable=false)
//    private Film film;

}
