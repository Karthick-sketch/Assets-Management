package com.karthick.assetsmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity(name = "assets")
public class Asset {
    @Id
    @GeneratedValue
    private int id;
    private String serialNumber;
    private String type;
    private String name;
    private String company;
    private double price;
    private Date manufactureDate;
    private int warranty;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
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
                ", price=" + price +
                ", manufactureDate=" + manufactureDate +
                ", warranty=" + warranty +
                ", lifetime='" + lifetime + '\'' +
                '}';
    }
}
