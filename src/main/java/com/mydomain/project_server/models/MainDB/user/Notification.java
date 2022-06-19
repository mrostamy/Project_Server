package com.mydomain.project_server.models.MainDB.user;

import com.mydomain.project_server.models.BaseEntity;
import com.mydomain.project_server.models.MainDB.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Notification extends BaseEntity<String> {

    public Notification() {
        this.setId(UUID.randomUUID().toString());
    }

    @NotNull
    private boolean enterEmail;

    @NotNull
    private boolean enterSms;

    @NotNull
    private boolean enterTelegram;

    @NotNull
    private boolean exitEmail;

    @NotNull
    private boolean exitSms;

    @NotNull
    private boolean exitTelegram;


    @NotNull
    private boolean ticketEmail;

    @NotNull
    private boolean ticketSms;

    @NotNull
    private boolean ticketTelegram;

    @NotNull
    private boolean loginEmail;

    @NotNull
    private boolean loginSms;

    @NotNull
    private boolean loginTelegram;



    @OneToOne
    User user;


}
