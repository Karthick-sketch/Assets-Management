package com.karthick.assetsmanagement.service;

import com.karthick.assetsmanagement.common.ApiResponse;
import com.karthick.assetsmanagement.entity.AssetStatus;

import java.util.List;
import java.util.Map;

public interface AssetStatusService {
    List<AssetStatus> findAllAssetStatus();

    ApiResponse findAssetStatusById(int id);

    ApiResponse createNewAssetStatus(AssetStatus assetStatus);

    ApiResponse updateAssetStatusByFields(int id, Map<String, Object> fields);

    void deleteAssetStatusById(int id);
}
