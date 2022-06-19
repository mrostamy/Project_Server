package com.mydomain.project_server.helpers;

import com.mydomain.project_server.models.MainDB.Token;
import com.mydomain.project_server.models.MainDB.User;
import com.mydomain.project_server.dto.common.token.TokenRequestDto;
import com.mydomain.project_server.dto.common.token.TokenResponseDto;
import com.mydomain.project_server.services.site.TokenService;
import com.mydomain.project_server.services.site.admin.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class TokenHelper {


    @Autowired
    UserService service;

    @Autowired
    TokenService t_service;

    @Autowired
    HttpServletRequest request;

    @Value("${refresh_token_clintID}")
    String clientId;

    private TokenHelper() {
    }

    private static TokenHelper ourInstance;

    public static TokenHelper getInstance() {
        if (ourInstance == null) {
            ourInstance = new TokenHelper();
        }
        return ourInstance;
    }

    public TokenResponseDto generateAccessToken(User user, String refreshToken) {

        LocalDateTime expiration = LocalDateTime.now().plusMinutes(7);
        LocalDateTime issuerAt = LocalDateTime.now();

        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.ID, user.getId());
        claims.put(Claims.AUDIENCE, "https://localhost:3000");
        claims.put(Claims.EXPIRATION, expiration);
        claims.put(Claims.SUBJECT, user.getName());
        claims.put(Claims.ISSUER, "https://localhost:8080/project_server");
        claims.put(Claims.ISSUED_AT, issuerAt);

        //var roles=user.getRoles();

        var newAccessToken = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "jwt.secret")
                .compact();

        var response = new TokenResponseDto();
        response.setToken(newAccessToken);
        response.setRefreshToken(refreshToken);
        return response;
    }

    public TokenResponseDto generateNewToken(TokenRequestDto requestDto) {

        var user = service.getUserByUsername(requestDto.getUsername());
        if (user != null && user.getPassword().equalsIgnoreCase(new BCryptPasswordEncoder().encode(requestDto.getPassword()))) {


            var newRefreshToken = createRefreshToken(clientId, user.getId(), requestDto.isRemember());

            var oldRefreshToken = t_service.getAllTokenByUserId(user.getId());

            if (!oldRefreshToken.isEmpty()) {
                for (Token token : oldRefreshToken) {

                    t_service.deleteTokenByToken(token);
                }

            }

            t_service.add(newRefreshToken);


            var accessToken = generateAccessToken(user, newRefreshToken.getValue());

            return new TokenResponseDto(accessToken.getToken(), accessToken.getRefreshToken(), true, "");
        } else {

            return new TokenResponseDto(null, null, false, "username or password is not valid");

        }

    }

    public Token createRefreshToken(String clientId, String userId, boolean isRemember) {

        var user = service.getUser(userId);

        var token = new Token();

        token.setClientID(clientId);
        token.setUser(user);
        token.setExpire((isRemember) ? LocalDateTime.now().plusDays(7) : LocalDateTime.now().plusDays(1));
        token.setValue(UUID.randomUUID().toString());
        token.setIp(request.getRemoteAddr());

        return new Token();


    }

    public TokenResponseDto refreshAccessToken(TokenRequestDto requestDto) {

        var refreshToken = t_service.getToken(clientId, requestDto.getRefreshToken(), request.getRemoteAddr());

        if (refreshToken == null) {
            return new TokenResponseDto(null, null, false, "error in auto authentication");
        }

        if (refreshToken.getExpire().isAfter(LocalDateTime.now())) {
            return new TokenResponseDto(null, null, false, "error in auto authentication");
        }

        var user = service.getUser(refreshToken.getUser().getId());
        if (user == null) {
            return new TokenResponseDto(null, null, false, "error in auto authentication");
        }

        var response = generateAccessToken(user, refreshToken.getValue());

        return new TokenResponseDto(response.getToken(), null, true, "");
    }

}



