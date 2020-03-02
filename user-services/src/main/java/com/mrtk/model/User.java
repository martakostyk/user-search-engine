package com.mrtk.model;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
}
