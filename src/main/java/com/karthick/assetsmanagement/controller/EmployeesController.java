package com.karthick.assetsmanagement.controller;

import com.karthick.assetsmanagement.entity.Employee;
import com.karthick.assetsmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("employees")
public class EmployeesController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("{employee-id}")
    public Optional<Employee> getEmployeeById(@PathVariable("employee-id") int id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee employee) {
        return employeeService.createNewEmployee(employee);
    }

    @PatchMapping("{employee-id}")
    public Employee updateEmployeeById(@PathVariable("employee-id") int id, @RequestBody Map<String, Object> updatedEmployee) {
        return employeeService.updateEmployeeByFields(id, updatedEmployee);
    }

    @DeleteMapping("{employee-id}")
    public void deleteEmployeeById(@PathVariable("employee-id") int id) {
        employeeService.deleteEmployeeById(id);
    }
}
