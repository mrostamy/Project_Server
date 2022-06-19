package com.mydomain.project_server.repositories.MainDB;

import com.mydomain.project_server.models.MainDB.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends CrudRepository<Token, String> {

    List<Token> findAllByUserId(String userId);

    Token findTokenByClientIDAndValueAndIp(String clientId, String value,String ip);


}
