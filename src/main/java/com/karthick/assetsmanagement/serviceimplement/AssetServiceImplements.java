package com.karthick.assetsmanagement.serviceimplement;

import com.karthick.assetsmanagement.common.ApiResponse;
import com.karthick.assetsmanagement.exception.BadRequestException;
import com.karthick.assetsmanagement.entity.Asset;
import com.karthick.assetsmanagement.repository.AssetRepository;
import com.karthick.assetsmanagement.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AssetServiceImplements implements AssetService {
    @Autowired
    AssetRepository assetRepository;

    public List<Asset> findAllAssets() {
        return assetRepository.findAll();
    }

    public ApiResponse findAssetById(int id) {
        ApiResponse apiResponse = new ApiResponse();
        Optional<Asset> asset = assetRepository.findById(id);
        if (asset.isEmpty()) {
            throw new NoSuchElementException("expecting asset is not found");
        }
        apiResponse.setData(asset.get());
        return apiResponse;
    }

    public ApiResponse createNewAsset(Asset asset) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setData(assetRepository.save(asset));
        } catch (AssertionError e) {
            throw new BadRequestException(e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse updateAssetByFields(int id, Map<String, Object> fields) {
        Optional<Asset> asset = assetRepository.findById(id);
        if (asset.isEmpty()) {
            throw new NoSuchElementException("expecting asset is not found");
        }
        ApiResponse apiResponse = new ApiResponse();
        try {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Asset.class, key);
                if (field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, asset.get(), value);
                }
            });
            apiResponse.setData(assetRepository.save(asset.get()));
        } catch (AssertionError e) {
            throw new BadRequestException(e.getMessage());
        }
        return apiResponse;
    }

    public void deleteAssetById(int id) {
        assetRepository.deleteById(id);
    }
}
