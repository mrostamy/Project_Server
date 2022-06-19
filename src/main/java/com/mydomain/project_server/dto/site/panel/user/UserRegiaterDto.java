package com.mydomain.project_server.dto.site.panel.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegiaterDto {

    @NotBlank(message = "username can not be empty")
    @Email(message = "email is not valid")
    private String username;

    @NotBlank(message = "password can not be empty")
    @Size(min = 4,max = 10,message = "password must be between 4 and 10 character")
    private String password;

    @NotBlank
    private String name;

    private String phone_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
