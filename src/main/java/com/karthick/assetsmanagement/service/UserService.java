package com.karthick.assetsmanagement.service;

import com.karthick.assetsmanagement.common.ApiResponse;
import com.karthick.assetsmanagement.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAllUsers();

    ApiResponse findUserById(int id);

    ApiResponse createNewUser(User user);

    ApiResponse updateUserByFields(int id, Map<String, Object> fields);

    void deleteUserById(int id);
}
