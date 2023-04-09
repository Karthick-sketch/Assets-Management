package com.karthick.assetsmanagement.serviceimplement;

import com.karthick.assetsmanagement.common.ApiResponse;
import com.karthick.assetsmanagement.common.BadRequestException;
import com.karthick.assetsmanagement.entity.User;
import com.karthick.assetsmanagement.repository.UserRepository;
import com.karthick.assetsmanagement.service.UserService;
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
public class UserServiceImplements implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public ApiResponse findUserById(int id) {
        ApiResponse apiResponse = new ApiResponse();
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NoSuchElementException("expecting asset is not found");
        }
        apiResponse.setData(user.get());
        return apiResponse;
    }

    public ApiResponse createNewUser(User user) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            user.setCreatedAt(LocalDateTime.now());
            apiResponse.setData(userRepository.save(user));
        } catch (AssertionError e) {
            throw new BadRequestException(e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse updateUserByFields(int id, Map<String, Object> fields) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NoSuchElementException("expecting asset is not found");
        }
        ApiResponse apiResponse = new ApiResponse();
        try {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(User.class, key);
                if (field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, user.get(), value);
                }
            });
            apiResponse.setData(userRepository.save(user.get()));
        } catch (AssertionError e) {
            throw new BadRequestException(e.getMessage());
        }
        return apiResponse;
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
