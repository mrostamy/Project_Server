package com.mydomain.project_server.dto.site.panel.entry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntryReturnDto {

    private double price;
    private boolean status;
    private boolean approved;
    private boolean regected;
    private String text;
    private String walletName;
    private String bankName;
    private String ownerName;
    private String shaba;
    private String cardNumber;


}
