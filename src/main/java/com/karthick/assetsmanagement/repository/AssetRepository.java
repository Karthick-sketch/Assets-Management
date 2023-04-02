package com.karthick.assetsmanagement.repository;

import com.karthick.assetsmanagement.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
}
