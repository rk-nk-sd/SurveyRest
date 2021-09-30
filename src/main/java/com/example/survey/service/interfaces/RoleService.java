package com.example.survey.service.interfaces;

import com.example.survey.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role createRole(Role role);
    void delete(Long id);
    Optional<Role> getCurrentRole(Long id);
    Role update(Role role);
    List<Role> getAllRole();
}
