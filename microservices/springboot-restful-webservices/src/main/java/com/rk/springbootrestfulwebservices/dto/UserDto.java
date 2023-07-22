package com.rk.springbootrestfulwebservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UserDto {
    private Long id;
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;
    @NotEmpty(message = "User last nam e should not be nul lor empty")
    private String lastName;
    @Email(message = "Email address should be valid")
    @NotEmpty(message = "User email should not be null or empty")
    private String email;
}
