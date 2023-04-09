package com.karthick.assetsmanagement.service;

import com.karthick.assetsmanagement.common.ApiResponse;
import com.karthick.assetsmanagement.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> findAllEmployees();

    ApiResponse findEmployeeById(int id);

    ApiResponse createNewEmployee(Employee employee);

    ApiResponse updateEmployeeByFields(int id, Map<String, Object> updatedEmployee);

    void deleteEmployeeById(int id);
}
