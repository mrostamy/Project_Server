package com.mydomain.project_server.dto.site.panel.easyPay;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EasyPayCreateUpdateDto {

    private String walletGateId;

    @NotNull
    private boolean isWallet;

    @NotNull
    private String name;

    @NotNull
    private int price;

    @NotNull
    private String text;

    @NotNull
    private boolean isCoupon;

    @NotNull
    private boolean isUsername;

    @NotNull
    private boolean isUserPhone;


    @NotNull
    private boolean isUserEmail;

    @NotNull
    private boolean isUserText;

    @NotNull
    private boolean isUserTextRequired;

    @NotNull
    private boolean UserNameExplain;

    @NotNull
    private boolean UserPhoneExplain;

    @NotNull
    private boolean isCountLimit;

    @NotNull
    private int CountLimit;

    private boolean returnSuccess;

    private boolean returnFail;


}
