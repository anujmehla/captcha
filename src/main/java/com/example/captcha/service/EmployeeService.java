package com.example.captcha.service;

import com.example.captcha.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void createEmployee(Employee e);
    List<Employee> getAllEmployees();
    Optional<Employee> getOneEmployee(Integer id);
}
