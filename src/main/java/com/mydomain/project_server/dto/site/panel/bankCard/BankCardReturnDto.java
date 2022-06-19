package com.mydomain.project_server.dto.site.panel.bankCard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankCardReturnDto {

    private String bankName;

    private String ownerName;

    private String shaba;

    private String cardNumber;

    private boolean approve;


}
