package com.mydomain.project_server.dto.site.panel.ticket;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TicketContentForCreateDto {

    @NotNull
    @Length(max = 1000)
    private String text;
    private MultipartFile file;
}
