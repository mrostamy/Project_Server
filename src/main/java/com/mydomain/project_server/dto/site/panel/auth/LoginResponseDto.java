package com.mydomain.project_server.dto.site.panel.auth;

import com.mydomain.project_server.models.MainDB.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDto {

    private String token;

    private String refreshToken;

    private User user;
}
