package com.karthick.assetsmanagement.serviceimplement;

import com.karthick.assetsmanagement.entity.Employee;
import com.karthick.assetsmanagement.repository.EmployeeRepository;
import com.karthick.assetsmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee createNewEmployee(Employee employee) {
        employee.setCreatedAt(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeByFields(int id, Map<String, Object> fields) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Employee.class, key);
                if (field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, employee.get(), value);
                }
            });
            return employeeRepository.save(employee.get());
        }
        return null;
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
