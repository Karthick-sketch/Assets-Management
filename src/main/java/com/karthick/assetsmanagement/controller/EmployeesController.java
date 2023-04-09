package com.karthick.assetsmanagement.controller;

import com.karthick.assetsmanagement.common.ApiResponse;
import com.karthick.assetsmanagement.entity.Employee;
import com.karthick.assetsmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("{employee-id}")
    public ResponseEntity<ApiResponse> getEmployeeById(@PathVariable("employee-id") int id) {
        ApiResponse apiResponse = employeeService.findEmployeeById(id);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createNewEmployee(@RequestBody Employee employee) {
        ApiResponse apiResponse = employeeService.createNewEmployee(employee);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PatchMapping("{employee-id}")
    public ResponseEntity<ApiResponse> updateEmployeeById(@PathVariable("employee-id") int id, @RequestBody Map<String, Object> updatedEmployee) {
        ApiResponse apiResponse = employeeService.updateEmployeeByFields(id, updatedEmployee);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @DeleteMapping("{employee-id}")
    public void deleteEmployeeById(@PathVariable("employee-id") int id) {
        employeeService.deleteEmployeeById(id);
    }
}
