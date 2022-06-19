package com.mydomain.project_server.models.FinancialDB.accountant;

import com.mydomain.project_server.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Factor extends BaseEntity<String> {
    public Factor() {
        this.setId(UUID.randomUUID().toString());
    }

    private double price;
    private double endPrice;

    private boolean status;
    private boolean approved;
    private boolean regected;
    private String text;
    private String bankName;
    private String refBank;
    private Short kind;
    private Short bank;

    private String ownerName;

    private String shaba;
    private String giftCode;
    private boolean isGifted;

    private String cardNumber;

    private boolean approve;
    private String user_id;
    private String userName;
    private String enterMoneyWallet_id;
    private String gate_id;
    private String bankCard_id;

}
