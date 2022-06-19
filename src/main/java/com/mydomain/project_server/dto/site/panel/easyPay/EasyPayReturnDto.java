package com.mydomain.project_server.dto.site.panel.easyPay;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EasyPayReturnDto {

    private String id;
    
    private String walletGateId;

    private boolean isWallet;


    private String name;


    private int price;


    private String text;


    private boolean isCoupon;


    private boolean isUsername;


    private boolean isUserPhone;




    private boolean isUserEmail;


    private boolean isUserText;


    private boolean isUserTextRequired;


    private boolean UserNameExplain;


    private boolean UserPhoneExplain;


    private boolean isCountLimit;


    private int CountLimit;

    private boolean returnSuccess;

    private boolean returnFail;

}
