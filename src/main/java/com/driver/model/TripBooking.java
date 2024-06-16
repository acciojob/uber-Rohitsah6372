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
public class TripBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tripBookingId;

    String fromLocation;
    String toLocation;
    int distanceInKm;

    TripStatus tripStatus;

    @OneToOne
    Cab cab;


}
