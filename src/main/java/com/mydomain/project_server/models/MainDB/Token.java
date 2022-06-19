package com.mydomain.project_server.models.MainDB;

import com.mydomain.project_server.models.BaseEntity;
import com.mydomain.project_server.models.MainDB.User;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Token extends BaseEntity<String> {

    public Token() {
        this.setId(UUID.randomUUID().toString());
    }

    @NotNull
    private String clientID;

    @NotNull
    private String value;

    @NotNull
    private LocalDateTime expire;

    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @OneToOne
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getExpire() {
        return expire;
    }

    public void setExpire(LocalDateTime expire) {
        this.expire = expire;
    }
}
