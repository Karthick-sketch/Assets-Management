package com.karthick.assetsmanagement.serviceimplement;

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
import java.util.Optional;

@Service
public class UserServiceImplements implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    public User createNewUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User updateUserByFields(int id, Map<String, Object> fields) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(User.class, key);
                if (field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, user.get(), value);
                }
            });
            return userRepository.save(user.get());
        }
        return null;
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
