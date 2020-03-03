package com.mrtk.model;

import javax.persistence.*;

@Entity
@Table(name = "ARTICLES")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "user_id")
    private long user_id;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getUser_id() {
        return user_id;
    }
}
