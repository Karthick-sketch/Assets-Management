package com.karthick.assetsmanagement.service;

import com.karthick.assetsmanagement.common.ApiResponse;
import com.karthick.assetsmanagement.entity.Asset;

import java.util.List;
import java.util.Map;

public interface AssetService {
    List<Asset> findAllAssets();

    ApiResponse findAssetById(int id);

    ApiResponse createNewAsset(Asset asset);

    ApiResponse updateAssetByFields(int id, Map<String, Object> fields);

    void deleteAssetById(int id);
}
