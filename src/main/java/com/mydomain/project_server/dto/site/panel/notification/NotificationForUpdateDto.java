package com.mydomain.project_server.dto.site.panel.notification;

import javax.validation.constraints.NotNull;

public class NotificationForUpdateDto {

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

}
