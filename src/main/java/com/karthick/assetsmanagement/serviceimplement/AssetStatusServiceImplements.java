package com.karthick.assetsmanagement.serviceimplement;

import com.karthick.assetsmanagement.entity.AssetStatus;
import com.karthick.assetsmanagement.repository.AssetStatusRepository;
import com.karthick.assetsmanagement.service.AssetStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AssetStatusServiceImplements implements AssetStatusService {
    @Autowired
    private AssetStatusRepository assetStatusRepository;

    public List<AssetStatus> findAllAssetStatus() {
        return assetStatusRepository.findAll();
    }

    public Optional<AssetStatus> findAssetStatusById(int id) {
        return assetStatusRepository.findById(id);
    }

    public AssetStatus createNewAssetStatus(AssetStatus assetStatus) {
        assetStatus.setCreatedAt(LocalDateTime.now());
        return assetStatusRepository.save(assetStatus);
    }

    public AssetStatus updateAssetStatusByFields(int id, Map<String, Object> fields) {
        Optional<AssetStatus> assetStatus = assetStatusRepository.findById(id);
        if (assetStatus.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(AssetStatus.class, key);
                if (field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, assetStatus.get(), value);
                }
            });
            return assetStatusRepository.save(assetStatus.get());
        }
        return null;
    }

    public void deleteAssetStatusById(int id) {
        assetStatusRepository.deleteById(id);
    }
}
