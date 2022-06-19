package com.mydomain.project_server.models.MainDB.user;

import com.mydomain.project_server.models.BaseEntity;
import com.mydomain.project_server.models.MainDB.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Document extends BaseEntity<String> {

    private boolean status;

    private String name;
    private String fatherName;
    private String address;

    private int approve;//0:no 1:in inspect 2:yes

    private String message;
    @Transient
    private MultipartFile picture;

    private String nationalCode;

    private LocalDateTime birthDay;


    @OneToOne
    private User user;
}
