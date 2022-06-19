package com.mydomain.project_server.models.MainDB;

import com.mydomain.project_server.models.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Ticket extends BaseEntity<String> {

    public Ticket() {
        this.setId(UUID.randomUUID().toString());
    }

    @NotNull
    private String title;

    @NotNull
    private boolean closed;

    @NotNull
    private short level;

    @NotNull
    private short department;


    @NotNull
    private boolean isAdminSide;

    @OneToOne
    User user;

    @OneToMany
    @JoinColumn
    List<TicketContent> ticketContents;

}
