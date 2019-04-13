package com.darkness.common;

import com.darkness.entity.Role;
import com.darkness.entity.User;
import com.darkness.service.RoleService;
import com.darkness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashSet;

@Component
public class UserDataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        // Roles
        if (roleService.findByName("ROLE_ADMIN") == null) {
            roleService.save(new Role("ROLE_ADMIN"));
        }

        if (roleService.findByName("ROLE_MEMBER") == null) {
            roleService.save(new Role("ROLE_MEMBER"));
        }

        // Admin account
        if (userService.findByEmail("admin@gmail.com") == null) {
            User admin = new User();
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleService.findByName("ROLE_ADMIN"));
            roles.add(roleService.findByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userService.save(admin);
        }

        // Member account
        if (userService.findByEmail("member@gmail.com") == null) {
            User user = new User();
            user.setEmail("member@gmail.com");
            user.setPassword(passwordEncoder.encode("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleService.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            userService.save(user);
        }

    }
}
