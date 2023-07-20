package com.rk.springbootrestfulwebservices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
