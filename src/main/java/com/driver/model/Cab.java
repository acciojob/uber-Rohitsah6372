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
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String cabNumber;

    String cabType;

    int rateKm;

    boolean avialable;

    @OneToOne
    Driver driver;

    @OneToOne
    @JoinColumn
    TripBooking tripBooking;

    @ManyToOne
    @JoinColumn
    Admin admin;

}
