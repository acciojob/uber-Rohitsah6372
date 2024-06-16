package com.driver.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    int distKm;

    boolean avialable;

}
