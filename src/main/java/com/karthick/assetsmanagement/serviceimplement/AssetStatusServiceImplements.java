package com.karthick.assetsmanagement.serviceimplement;

import com.karthick.assetsmanagement.common.ApiResponse;
import com.karthick.assetsmanagement.exception.BadRequestException;
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
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AssetStatusServiceImplements implements AssetStatusService {
    @Autowired
    private AssetStatusRepository assetStatusRepository;

    public List<AssetStatus> findAllAssetStatus() {
        return assetStatusRepository.findAll();
    }

    public ApiResponse findAssetStatusById(int id) {
        ApiResponse apiResponse = new ApiResponse();
        Optional<AssetStatus> employee = assetStatusRepository.findById(id);
        if (employee.isEmpty()) {
            throw new NoSuchElementException("expecting asset status is not found");
        }
        apiResponse.setData(employee.get());
        return apiResponse;
    }

    public ApiResponse createNewAssetStatus(AssetStatus assetStatus) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            assetStatus.setCreatedAt(LocalDateTime.now());
            apiResponse.setData(assetStatusRepository.save(assetStatus));
        } catch (AssertionError e) {
            throw new BadRequestException(e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse updateAssetStatusByFields(int id, Map<String, Object> fields) {
        Optional<AssetStatus> assetStatus = assetStatusRepository.findById(id);
        if (assetStatus.isEmpty()) {
            throw new NoSuchElementException("expecting asset status is not found");
        }
        ApiResponse apiResponse = new ApiResponse();
        try {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(AssetStatus.class, key);
                if (field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, assetStatus.get(), value);
                }
            });
            apiResponse.setData(assetStatusRepository.save(assetStatus.get()));
        } catch (AssertionError e) {
            throw new BadRequestException(e.getMessage());
        }
        return apiResponse;
    }

    public void deleteAssetStatusById(int id) {
        assetStatusRepository.deleteById(id);
    }
}
