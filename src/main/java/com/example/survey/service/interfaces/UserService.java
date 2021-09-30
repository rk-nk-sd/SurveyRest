package com.example.survey.service.interfaces;

import com.example.survey.entity.Role;
import com.example.survey.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    void deleteUser(int id);

    Optional<User> getUserById(int id);

    User updateUser(User user);

    List<User> getAllUsers();

    Optional<User> findById(int id);

    User findByLoginAndPassword(String name, String password);

    Role findByRoleName(String role);

    boolean isUserExistByEmail(String email);
}
