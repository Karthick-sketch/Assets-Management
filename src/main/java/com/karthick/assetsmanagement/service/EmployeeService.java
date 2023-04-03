package com.karthick.assetsmanagement.service;

import com.karthick.assetsmanagement.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAllEmployees();

    Optional<Employee> findEmployeeById(int id);

    Employee createNewEmployee(Employee employee);
}
