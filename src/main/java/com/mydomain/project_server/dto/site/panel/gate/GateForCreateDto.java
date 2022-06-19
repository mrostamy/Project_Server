package com.mydomain.project_server.dto.site.panel.gate;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class GateForCreateDto {

    @NotNull
    private boolean isIp;

    private boolean grouping;

    @NotNull
    private String siteName;

    @NotNull
    private String siteUrl;

    @NotNull
    private String contactNumber;

    @NotNull
    private String text;

    private MultipartFile file;
}
