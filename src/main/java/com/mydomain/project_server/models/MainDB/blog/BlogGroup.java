package com.mydomain.project_server.models.MainDB.blog;

import com.mydomain.project_server.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class BlogGroup extends BaseEntity<String> {
    public BlogGroup() {
        this.setId(UUID.randomUUID().toString());
    }

    private short parent;
    private String name;

    @OneToMany
    @JoinColumn
    private List<Blog> blogs;



}
