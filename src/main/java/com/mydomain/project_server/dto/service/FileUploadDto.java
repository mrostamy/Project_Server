package com.mydomain.project_server.dto.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileUploadDto {

    public FileUploadDto() {
    }

    private boolean status;
    private String message;
    private String publicId;
    private String url;
}
