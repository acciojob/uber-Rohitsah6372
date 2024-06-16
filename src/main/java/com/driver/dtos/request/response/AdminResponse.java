package com.driver.dtos.request.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminResponse {

    String name;
    String emailId;
    int number;
}
