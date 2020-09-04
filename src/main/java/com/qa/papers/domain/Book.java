package com.qa.papers.domain;


import javax.persistence.*;

@Entity
public class Book {

   @Id
   @GeneratedValue
    private Long id;

   @Column
    private String title;

   @Column
    private String description;

    @ManyToOne(targetEntity = Library.class)
    private Library library;

    public Book() {
    }

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}

