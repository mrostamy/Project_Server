package com.mydomain.project_server.dto.common.token;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TokenRequestDto {
    @NotNull
    private String grantType;
    @NotNull
    private String clientID;
    @NotNull
    private String username;
    private String refreshToken;
    private String password;

    private boolean isRemember = false;

}
