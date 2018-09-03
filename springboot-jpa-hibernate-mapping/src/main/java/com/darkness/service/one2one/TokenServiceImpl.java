package com.darkness.service.one2one;

import com.darkness.entity.one2one.Token;
import com.darkness.repository.one2one.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public List<Token> findAll() {
        return tokenRepository.findAll();
    }

    @Override
    public void save(Token token) {
        tokenRepository.save(token);
    }
}
