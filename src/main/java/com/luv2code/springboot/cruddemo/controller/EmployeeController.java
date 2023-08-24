package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.dtos.EmployeeDto;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.exceptions.employee.EmployeeNotFoundException;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId) {
        return employeeService.findById(employeeId).orElseThrow(
                () -> new EmployeeNotFoundException("Employee id: " + employeeId + " not found")
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return  employeeService.createEmployee(employeeDto);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }

    @DeleteMapping("{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId) {
        Optional<Employee> tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee.isEmpty()) {
            throw new IllegalArgumentException("The employee is not found of the Id " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee " + employeeId;
    }
}
