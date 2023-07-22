package com.karthick.assetsmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity(name = "asset_status")
public class AssetStatus {
    @Id
    @GeneratedValue
    private int id;
    private int employeeId;
    private int assetId;
    private int issuedBy; // user who issued the asset to employee
    private String status;
    private LocalDateTime createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public int getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(int issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AssetStatus{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", assetId=" + assetId +
                ", issuedBy=" + issuedBy +
                ", status='" + status + "'" +
                ", createdAt=" + createdAt +
                '}';
    }
}
