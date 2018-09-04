package com.darkness.service;

import com.darkness.entity.User;

public interface UserService {
    User findByEmail(String email);

    void save(User user);
}
