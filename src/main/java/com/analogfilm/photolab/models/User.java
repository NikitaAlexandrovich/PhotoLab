package com.analogfilm.photolab.models;

//import lombok.*;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Data
//@Entity
//@Table(name = "User")
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String username;
//    private String password;
//
//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles;
//}

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Data
@Table(name="User")
public class User {
    @Id
    private String username;
    private String password;
    private String role;

//    @OneToMany(mappedBy="user")
//    private Set<Order> Orders;
//
//    @OneToMany(mappedBy = "employee")
//    private Set<Order> EmployeeOrders;
}
