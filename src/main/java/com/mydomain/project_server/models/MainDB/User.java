package com.mydomain.project_server.models.MainDB;

import com.mydomain.project_server.models.BaseEntity;
import com.mydomain.project_server.models.MainDB.blog.Blog;
import com.mydomain.project_server.models.MainDB.user.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@XmlRootElement
@Getter
@Setter
public class User extends BaseEntity<String> {

    public User() {
        this.setId(UUID.randomUUID().toString());
    }

    private String name;

    private String username;

    private String phoneNumber;

    private String Address;

    private String password;

    private boolean gender;

    private LocalDateTime DateOfBirth;

    private String city;

    private boolean isActive;

    private boolean status;

    @OneToMany
    @JoinColumn
    private List<Photo> photos;

    @OneToMany(mappedBy = "users")
    private List<Role> roles;

    @OneToMany
    @JoinColumn
    private Collection<Notification> notifications;

    @OneToMany
    @JoinColumn
    private List<BankCard> bankCards;

    @OneToMany
    @JoinColumn
    private List<Token> tokens;

    @OneToMany
    @JoinColumn
    private List<Document> documents;

    @OneToMany
    @JoinColumn
    private List<Wallet> wallets;

    @OneToMany
    @JoinColumn
    private List<Ticket> tickets;

    @OneToMany
    @JoinColumn
    private List<EasyPay> easyPays;

    @OneToMany
    @JoinColumn
    private List<Blog> blogs;

}
