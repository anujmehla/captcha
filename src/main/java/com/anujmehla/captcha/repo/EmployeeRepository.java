package com.anujmehla.captcha.repo;

import com.anujmehla.captcha.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
