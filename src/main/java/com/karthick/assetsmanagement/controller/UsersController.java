package com.karthick.assetsmanagement.controller;

import com.karthick.assetsmanagement.entity.User;
import com.karthick.assetsmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Optional<User> getUserById(@PathVariable("user-id") int id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public User createNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

    @PatchMapping("{user-id}")
    public User updateUserById(@PathVariable("user-id") int id, @RequestBody Map<String, Object> updatedUser) {
        return userService.updateUserByFields(id, updatedUser);
    }

    @DeleteMapping("{user-id}")
    public void deleteUserById(@PathVariable("user-id") int id) {
        userService.deleteUserById(id);
    }
}
