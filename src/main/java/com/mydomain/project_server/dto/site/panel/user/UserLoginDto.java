package com.mydomain.project_server.dto.site.panel.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserLoginDto {

    @NotBlank(message = "username can not be empty")
    @Email(message = "email is not valid")
    private String username;

    @NotBlank(message = "password can not be empty")
    private String password;

    private boolean remember;
}
