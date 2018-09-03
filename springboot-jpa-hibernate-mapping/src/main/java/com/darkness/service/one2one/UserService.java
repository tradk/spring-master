package com.darkness.service.one2one;

import com.darkness.entity.one2one.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);
}
