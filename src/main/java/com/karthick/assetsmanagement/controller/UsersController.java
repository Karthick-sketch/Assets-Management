package com.karthick.assetsmanagement.controller;

import com.karthick.assetsmanagement.common.ApiResponse;
import com.karthick.assetsmanagement.entity.User;
import com.karthick.assetsmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("{user-id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable("user-id") int id) {
        ApiResponse apiResponse = userService.findUserById(id);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createNewUser(@RequestBody User user) {
        ApiResponse apiResponse = userService.createNewUser(user);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PatchMapping("{user-id}")
    public ResponseEntity<ApiResponse> updateUserById(@PathVariable("user-id") int id, @RequestBody Map<String, Object> updatedUser) {
        ApiResponse apiResponse = userService.updateUserByFields(id, updatedUser);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @DeleteMapping("{user-id}")
    public void deleteUserById(@PathVariable("user-id") int id) {
        userService.deleteUserById(id);
    }
}
