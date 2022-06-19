package com.mydomain.project_server.dto.site.panel.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserForDetailedDto {

    private String id;
    private String name;
    private String userName;
    private String phoneNumber;
    private String address;
    private String city;
    private LocalDateTime lastActive;
    private boolean gender;
    private int age;
    private String photoUrl;


}
