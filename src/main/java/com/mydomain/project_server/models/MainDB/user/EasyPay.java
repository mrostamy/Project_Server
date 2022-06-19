package com.mydomain.project_server.models.MainDB.user;

import com.mydomain.project_server.models.BaseEntity;
import com.mydomain.project_server.models.MainDB.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Getter
@Setter
public class EasyPay extends BaseEntity<String> {

    public EasyPay() {
        this.setId(UUID.randomUUID().toString());
    }

    @NotNull
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

    @OneToOne
    private User user;


}
