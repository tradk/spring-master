package com.darkness.common.one2one;

import com.darkness.entity.one2one.Token;
import com.darkness.entity.one2one.User;
import com.darkness.service.one2one.TokenService;
import com.darkness.service.one2one.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Component
public class One2OneDataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // Save data
        User member = new User("member@gmail.com", new Token(UUID.randomUUID().toString()));
        User admin = new User("admin@gmail.com", new Token(UUID.randomUUID().toString()));

        userService.save(member);
        userService.save(admin);

        // Get data
        List<User> users = userService.findAll();
        List<Token> tokens = tokenService.findAll();
    }
}
