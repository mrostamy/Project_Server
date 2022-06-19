package com.mydomain.project_server.models.MainDB.user;

import com.mydomain.project_server.models.BaseEntity;
import com.mydomain.project_server.models.MainDB.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Wallet extends BaseEntity<String> {

    public Wallet() {
        this.setId(UUID.randomUUID().toString());
    }

    private boolean isMain;

    private boolean isSms;

    private boolean isBlock;

    private String name;

    private long code;

    private int inventory;

    private int enterMoney;

    private int exitMoney;

    private int onExitMoney;

    @OneToOne
    private User user;

    @OneToMany
    @JoinColumn
    List<Gate> gates;

}
