package com.karthick.assetsmanagement.service;

import com.karthick.assetsmanagement.entity.AssetStatus;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AssetStatusService {
    List<AssetStatus> findAllAssetStatus();

    Optional<AssetStatus> findAssetStatusById(int id);

    AssetStatus createNewAssetStatus(AssetStatus assetStatus);

    AssetStatus updateAssetStatusByFields(int id, Map<String, Object> fields);

    void deleteAssetStatusById(int id);
}
