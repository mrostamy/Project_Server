package com.mydomain.project_server.dto.common.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
public class TokenResponseDto {

    private String token;

    private String refreshToken;

    private boolean status;

    private String message;


    public TokenResponseDto() {

    }
}
