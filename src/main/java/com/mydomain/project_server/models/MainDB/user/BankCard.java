package com.mydomain.project_server.models.MainDB.user;

import com.mydomain.project_server.models.BaseEntity;
import com.mydomain.project_server.models.MainDB.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@Setter
@Entity
public class BankCard extends BaseEntity<String> {

    public BankCard() {
        this.setId(UUID.randomUUID().toString());
    }

    private String bankName;

    private String ownerName;

    private String shaba;

    private String cardNumber;

    private boolean approve;

    @NotEmpty
    @Length(min = 2, max = 2)
    private String expireDateMonth;

    @NotEmpty
    @Length(min = 2, max = 2)
    private String expireDateYear;

    @OneToOne
    private User user;

}

