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
public class Driver {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String number;
    Boolean avialable;
    String password;

    @OneToOne
    Cab cab;

    @OneToMany
    TripBooking tripBooking;

}
