package com.example.demo.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private String briefDescription;

    @ManyToOne(targetEntity = Category.class)
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String name, String author, String briefDescription) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.briefDescription = briefDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }
}

