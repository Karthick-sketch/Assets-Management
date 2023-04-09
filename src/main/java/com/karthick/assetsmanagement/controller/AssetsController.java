package com.karthick.assetsmanagement.controller;

import com.karthick.assetsmanagement.common.ApiResponse;
import com.karthick.assetsmanagement.entity.Asset;
import com.karthick.assetsmanagement.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<ApiResponse> getAssetById(@PathVariable("asset-id") int assetId) {
        ApiResponse apiResponse = assetService.findAssetById(assetId);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createNewAsset(@RequestBody Asset asset) {
        ApiResponse apiResponse = assetService.createNewAsset(asset);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PatchMapping("{asset-id}")
    public ResponseEntity<ApiResponse> updateAssetById(@PathVariable("asset-id") int id, @RequestBody Map<String, Object> json) {
        ApiResponse apiResponse = assetService.updateAssetByFields(id, json);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @DeleteMapping("{asset-id}")
    public void deleteAssetById(@PathVariable("asset-id") int id) {
        assetService.deleteAssetById(id);
    }
}
