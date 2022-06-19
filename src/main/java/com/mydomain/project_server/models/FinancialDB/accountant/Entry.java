package com.mydomain.project_server.models.FinancialDB.accountant;

import com.mydomain.project_server.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Entry extends BaseEntity<String> {

    public Entry() {
        this.setId(UUID.randomUUID().toString());
    }

    private double price;

    private boolean pardakht;
    private boolean approved;
    private boolean regected;
    private String text;
    private String walletName;

    private String user_id;
    private String wallet_id;
    private String bankCard_id;

}
