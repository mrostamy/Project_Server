package com.mydomain.project_server.dto.site;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationDto {

    private int pageNumber = 1;
    private int pageSize = 10;
    private String filter;
    private String sortHeader;
    private String sortDirection;

    public void setPageSize(int pageSize) {
        this.pageSize = Math.min(pageSize, 50);
    }

    public int getPageSize() {
        return this.pageSize;
    }
}
