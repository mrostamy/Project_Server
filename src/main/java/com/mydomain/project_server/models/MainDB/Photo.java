package com.mydomain.project_server.models.MainDB;

import com.mydomain.project_server.models.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
public class Photo extends BaseEntity<String> {

    public Photo(){
        this.setId(UUID.randomUUID().toString());
    }
    private String url;
    private String title;
    private String description;

//    @NotEmpty
    private boolean isMain;


//    @NotEmpty
//    private String userId;

    @OneToOne
    private User user;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
