package com.mydomain.project_server.models.MainDB;

import com.mydomain.project_server.models.BaseEntity;
import com.mydomain.project_server.models.MainDB.Ticket;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.util.UUID;

@Getter
@Setter
@Entity
public class TicketContent extends BaseEntity<String> {
    public TicketContent() {
        this.setId(UUID.randomUUID().toString());
    }

    private boolean isAdminSide;

    private String text;

    @Transient
    private MultipartFile file;

    @OneToOne
    private Ticket ticket;



}
