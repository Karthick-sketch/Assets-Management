package com.karthick.assetsmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity(name = "assets")
public class Asset {
    @Id
    @GeneratedValue
    private int id;
    private String serialNumber;
    private String type;
    private String name;
    private String company;
    private float cost;
    private LocalDateTime manufactureDate;
    private String lifetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public LocalDateTime getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDateTime manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getLifetime() {
        return lifetime;
    }

    public void setLifetime(String lifetime) {
        this.lifetime = lifetime;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", cost=" + cost +
                ", manufactureDate=" + manufactureDate +
                ", lifetime='" + lifetime + '\'' +
                '}';
    }
}
