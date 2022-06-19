package com.mydomain.project_server.models.LogDB;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String Application;
    private String level;
    private String msg;
    private Date date;
}
