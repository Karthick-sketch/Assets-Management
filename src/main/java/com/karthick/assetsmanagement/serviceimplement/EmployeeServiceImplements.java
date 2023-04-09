package com.karthick.assetsmanagement.serviceimplement;

import com.karthick.assetsmanagement.common.ApiResponse;
import com.karthick.assetsmanagement.common.BadRequestException;
import com.karthick.assetsmanagement.entity.Asset;
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
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeServiceImplements implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public ApiResponse findEmployeeById(int id) {
        ApiResponse apiResponse = new ApiResponse();
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new NoSuchElementException("expecting employee is not found");
        }
        apiResponse.setData(employee.get());
        return apiResponse;
    }

    public ApiResponse createNewEmployee(Employee employee) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            employee.setCreatedAt(LocalDateTime.now());
            apiResponse.setData(employeeRepository.save(employee));
        } catch (AssertionError e) {
            throw new BadRequestException(e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse updateEmployeeByFields(int id, Map<String, Object> fields) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new NoSuchElementException("expecting employee is not found");
        }
        ApiResponse apiResponse = new ApiResponse();
        try {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Asset.class, key);
                if (field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, employee.get(), value);
                }
            });
            apiResponse.setData(employeeRepository.save(employee.get()));
        } catch (AssertionError e) {
            throw new BadRequestException(e.getMessage());
        }
        return apiResponse;
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
