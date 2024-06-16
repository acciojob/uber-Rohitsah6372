package com.driver.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(nullable = false, unique = true)
    String emailId;

    int age;

    int number;

    @Column(nullable = false, unique = true)
    String password;

    @OneToMany
    Driver driver;

    @OneToMany
    Cab cab;


}
