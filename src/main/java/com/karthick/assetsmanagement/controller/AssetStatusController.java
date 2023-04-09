package com.karthick.assetsmanagement.controller;

import com.karthick.assetsmanagement.common.ApiResponse;
import com.karthick.assetsmanagement.entity.AssetStatus;
import com.karthick.assetsmanagement.service.AssetStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/assetstatus")
public class AssetStatusController {
    @Autowired
    private AssetStatusService assetStatusService;

    @GetMapping
    public List<AssetStatus> getAllAssetStatus() {
        return assetStatusService.findAllAssetStatus();
    }

    @GetMapping("{asset-status-id}")
    public ResponseEntity<ApiResponse> getAssetStatusById(@PathVariable("asset-status-id") int id) {
        ApiResponse apiResponse = assetStatusService.findAssetStatusById(id);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> creatNewAssetStatus(@RequestBody AssetStatus assetStatus) {
        ApiResponse apiResponse = assetStatusService.createNewAssetStatus(assetStatus);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PatchMapping("{asset-status-id}")
    public ResponseEntity<ApiResponse> updateAssetStatusById(@PathVariable("asset-status-id") int id, @RequestBody Map<String, Object> updatedAssetStatus) {
        ApiResponse apiResponse = assetStatusService.updateAssetStatusByFields(id, updatedAssetStatus);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @DeleteMapping("{asset-status-id}")
    public void deleteAssetStatusById(@PathVariable("asset-status-id") int id) {
        assetStatusService.deleteAssetStatusById(id);
    }
}
