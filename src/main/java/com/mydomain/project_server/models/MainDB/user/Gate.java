package com.mydomain.project_server.models.MainDB.user;

import com.mydomain.project_server.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Gate extends BaseEntity<String> {

    public Gate() {
        this.setId(UUID.randomUUID().toString());
    }

    @NotNull
    private String ip;
    @NotNull
    private boolean isIp;

    @NotNull
    private boolean isActive;

    @NotNull
    private boolean isDirect;

    @NotNull
    private String siteName;

    @NotNull
    private String siteUrl;

    @NotNull
    private String contactNumber;

    @NotNull
    private String text;

    @NotNull
    private String grping;//grouping

    @NotNull
    private String iconUrl;

    @OneToOne
    Wallet wallet;
}
