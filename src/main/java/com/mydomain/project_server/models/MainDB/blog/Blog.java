package com.mydomain.project_server.models.MainDB.blog;

import com.mydomain.project_server.models.BaseEntity;
import com.mydomain.project_server.models.MainDB.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Blog extends BaseEntity<String> {
    public Blog() {
        this.setId(UUID.randomUUID().toString());
    }

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

    @OneToOne
    User user;

    @OneToOne
    BlogGroup blogGroup;

}
