package com.darkness.service;

import com.darkness.entity.Role;

public interface RoleService {
    Role findByName(String name);

    void save(Role role);
}
