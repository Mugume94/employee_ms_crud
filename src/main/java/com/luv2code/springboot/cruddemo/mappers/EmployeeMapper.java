package com.luv2code.springboot.cruddemo.mappers;

import com.luv2code.springboot.cruddemo.dtos.EmployeeDto;
import com.luv2code.springboot.cruddemo.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEntity(EmployeeDto employeeDto) {
        return Employee.builder()
                .firstName(employeeDto.firstName())
                .lastName(employeeDto.lastName())
                .email(employeeDto.email())
                .build();
    }
}
