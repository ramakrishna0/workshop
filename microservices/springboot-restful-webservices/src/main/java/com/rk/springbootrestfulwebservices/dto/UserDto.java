package com.rk.springbootrestfulwebservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDTO Model Implementation"
)
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UserDto {
    private Long id;
    @Schema(description = "User First Name")
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;
    @Schema(description = "User Last Name")
    @NotEmpty(message = "User last nam e should not be nul lor empty")
    private String lastName;
    @Schema(description = "User Email Address")
    @Email(message = "Email address should be valid")
    @NotEmpty(message = "User email should not be null or empty")
    private String email;
}
