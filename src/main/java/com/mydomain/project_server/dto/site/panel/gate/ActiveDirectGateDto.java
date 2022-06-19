package com.mydomain.project_server.dto.site.panel.gate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActiveDirectGateDto {

    private boolean isDirect;

    private String walletId;
}
