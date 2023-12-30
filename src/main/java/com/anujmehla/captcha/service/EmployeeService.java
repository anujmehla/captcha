package com.anujmehla.captcha.service;

import com.anujmehla.captcha.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void createEmployee(Employee e);
    List<Employee> getAllEmployees();
    Optional<Employee> getOneEmployee(Integer id);
}
