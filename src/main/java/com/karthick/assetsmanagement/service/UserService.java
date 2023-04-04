package com.karthick.assetsmanagement.service;

import com.karthick.assetsmanagement.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();

    Optional<User> findUserById(int id);

    public User createNewUser(User user);

    public User updateUserByFields(int id, Map<String, Object> fields);

    void deleteUserById(int id);
}
