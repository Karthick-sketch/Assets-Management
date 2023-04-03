package com.karthick.assetsmanagement.controller;

import com.karthick.assetsmanagement.entity.AssetStatus;
import com.karthick.assetsmanagement.service.AssetStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Optional<AssetStatus> getAssetStatusById(@PathVariable("asset-status-id") int id) {
        return assetStatusService.findAssetStatusById(id);
    }

    @PostMapping
    public AssetStatus creatNewAssetStatus(@RequestBody AssetStatus assetStatus) {
        return assetStatusService.createNewAssetStatus(assetStatus);
    }

    @PatchMapping("{asset-status-id}")
    public AssetStatus updateAssetStatusById(@PathVariable("asset-status-id") int id, @RequestBody Map<String, Object> updatedAssetStatus) {
        return assetStatusService.updateAssetStatusByFields(id, updatedAssetStatus);
    }

    @DeleteMapping("{asset-status-id}")
    public void deleteAssetStatusById(@PathVariable("asset-status-id") int id) {
        assetStatusService.deleteAssetStatusById(id);
    }
}
