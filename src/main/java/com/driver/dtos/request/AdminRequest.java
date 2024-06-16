package com.driver.dtos.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminRequest {
    String name;
    String emailId;
    int age;
    int number;
    String password;

}
