package com.mydomain.project_server.dto.site.panel.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserReturnDto {

    private String id;

    private String name;

    private String username;

    private String phoneNumber;

    private String Address;

    private boolean gender;

    private int age;

    private LocalDateTime DateOfBirth;

    private String city;

    private LocalDateTime lastActive;

    private String photoUrl;

}
