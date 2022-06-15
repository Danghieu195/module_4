package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private String briefDiscription;
    private String date;

    @ManyToOne(targetEntity = Category.class)
    private Category category;


    public Blog(){

    }

    public Blog(Integer id, String name, String author, String briefDiscription, String date) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.briefDiscription = briefDiscription;
        this.date = date;
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

    public String getBriefDiscription() {
        return briefDiscription;
    }

    public void setBriefDiscription(String briefDiscription) {
        this.briefDiscription = briefDiscription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
