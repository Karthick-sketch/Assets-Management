package com.karthick.assetsmanagement.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.karthick.assetsmanagement.entity.Asset;
import com.karthick.assetsmanagement.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    @Autowired
    AssetRepository assetRepository;

    @GetMapping
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @GetMapping("{asset-id}")
    public Optional<Asset> getAssetById(@PathVariable("asset-id") int assetId) {
        return assetRepository.findById(assetId);
    }

    @PostMapping
    public Asset createNewAsset(@RequestBody Asset asset) {
        assetRepository.save(asset);
        return asset;
    }
}
