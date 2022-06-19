package com.mydomain.project_server.dto.site.panel.blog;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BlogCreateUpdateDto {

    @NotNull
    @Length(max = 500)
    private String blogGroupId;

    @NotNull
    @Length(max = 500)
    private String title;
    @NotNull
    @Length(max = 500)
    private String tags;
    @NotNull
    @Length(max = 500)
    private String picAddress;
    @NotNull
    private String text;
    @NotNull
    @Length(max = 1000)
    private String summeryText;
    @NotNull
    private int viewCount;
    @NotNull
    private boolean status;
    @NotNull
    private boolean isSelected;

    private MultipartFile file;

}
