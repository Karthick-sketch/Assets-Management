package com.karthick.assetsmanagement.serviceimplement;

import com.karthick.assetsmanagement.entity.Asset;
import com.karthick.assetsmanagement.repository.AssetRepository;
import com.karthick.assetsmanagement.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AssetServiceImplements implements AssetService {
    @Autowired
    AssetRepository assetRepository;

    public List<Asset> findAllAssets() {
        return assetRepository.findAll();
    }

    public Optional<Asset> findAssetById(int id) {
        return assetRepository.findById(id);
    }

    public Asset createNewAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public Asset updateAssetByFields(int id, Map<String, Object> fields) {
        Optional<Asset> asset = assetRepository.findById(id);
        if (asset.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Asset.class, key);
                if (field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, asset.get(), value);
                }
            });
            return assetRepository.save(asset.get());
        }
        return null;
    }

    public void deleteAssetById(int id) {
        assetRepository.deleteById(id);
    }
}
