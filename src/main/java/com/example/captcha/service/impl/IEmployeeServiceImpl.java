package com.example.captcha.service.impl;

import com.example.captcha.model.Employee;
import com.example.captcha.repo.EmployeeRepository;
import com.example.captcha.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IEmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public void createEmployee(Employee e) {
        repository.save(e);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> getOneEmployee(Integer id) {
        return repository.findById(id);
    }
}
