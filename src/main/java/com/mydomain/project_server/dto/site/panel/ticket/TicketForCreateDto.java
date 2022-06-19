package com.mydomain.project_server.dto.site.panel.ticket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketForCreateDto {

    private String title;
    private boolean status;
    private boolean department;
}
