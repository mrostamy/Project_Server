package com.mydomain.project_server.services.site;

import com.mydomain.project_server.models.MainDB.Token;
import com.mydomain.project_server.repositories.MainDB.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenService {

    @Autowired
    TokenRepository repo;

    public List<Token> getAllTokenByUserId(String userId) {

        return repo.findAllByUserId(userId);

    }

    public Token getToken(String clientId, String value,String ip) {
        return repo.findTokenByClientIDAndValueAndIp(clientId, value,ip);
    }

    public void deleteTokenByToken(Token token) {

        repo.delete(token);
    }

    public void add(Token newRefreshToken) {

        repo.save(newRefreshToken);
    }
}
