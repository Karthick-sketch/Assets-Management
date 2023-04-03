package com.karthick.assetsmanagement.repository;

import com.karthick.assetsmanagement.entity.AssetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetStatusRepository extends JpaRepository<AssetStatus, Integer> {
}
