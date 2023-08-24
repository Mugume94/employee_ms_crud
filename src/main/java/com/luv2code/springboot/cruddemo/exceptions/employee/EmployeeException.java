package com.luv2code.springboot.cruddemo.exceptions.employee;

import org.springframework.http.HttpStatus;

public record EmployeeException(String message, HttpStatus httpStatus, String timestamp) {
}
