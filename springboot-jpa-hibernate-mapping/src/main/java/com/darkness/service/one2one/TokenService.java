package com.darkness.service.one2one;

import com.darkness.entity.one2one.Token;

import java.util.List;

public interface TokenService {
    List<Token> findAll();

    void save(Token token);
}
