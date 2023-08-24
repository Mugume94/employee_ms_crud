package com.luv2code.springboot.cruddemo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmployeeDto(
        @NotBlank(message = "First Name is required")
        String firstName,

        @NotBlank(message = "Last Name is required")
        String lastName,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email")
        String email) {
}
