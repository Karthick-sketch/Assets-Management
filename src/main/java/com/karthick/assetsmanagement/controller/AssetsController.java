package com.karthick.assetsmanagement.controller;

import com.karthick.assetsmanagement.entity.Asset;
import com.karthick.assetsmanagement.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    @Autowired
    AssetService assetService;

    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.findAllAssets();
    }

    @GetMapping("{asset-id}")
    public Optional<Asset> getAssetById(@PathVariable("asset-id") int assetId) {
        return assetService.findAssetById(assetId);
    }

    @PostMapping
    public Asset createNewAsset(@RequestBody Asset asset) {
        return assetService.createNewAsset(asset);
    }

    @PatchMapping("{asset-id}")
    public Asset updateAssetById(@PathVariable("asset-id") int id, @RequestBody Map<String, Object> json) {
        return assetService.updateAssetByFields(id, json);
    }

    @DeleteMapping("{asset-id}")
    public void deleteAssetById(@PathVariable("asset-id") int id) {
        assetService.deleteAssetById(id);
    }
}
