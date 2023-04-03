package com.karthick.assetsmanagement.service;

import com.karthick.assetsmanagement.entity.Asset;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AssetService {
    List<Asset> findAllAssets();

    Optional<Asset> findAssetById(int id);

    Asset createNewAsset(Asset asset);

    Asset updateAssetByFields(int id, Map<String, Object> fields);

    void deleteAssetById(int id);
}
