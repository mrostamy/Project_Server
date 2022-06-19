package com.mydomain.project_server.dto.site.panel.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserForAccountantDto {

    private String id;
    private String name;
    private String userName;
    private String phoneNumber;
    private boolean gender;
    private int age;
    private int inventorySum;
    private int EnterMoneySum;
    private int ExitMoneySum;
    private int onExitMoneySum;
    private String photoUrl;


}
