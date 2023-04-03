package com.karthick.assetsmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
    private String department;
    private boolean isActive;
    private LocalDateTime createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", email='" + email + "'" +
                ", phoneNumber='" + phoneNumber + "'" +
                ", role='" + role + "'" +
                ", department='" + department + "'" +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                '}';
    }
}
