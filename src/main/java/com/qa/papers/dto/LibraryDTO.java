package com.qa.papers.dto;

import java.util.ArrayList;
import java.util.List;

public class LibraryDTO {

    private Long id;
    private String name;
    private List<BookDTO> books = new ArrayList<>();

    public LibraryDTO() {
    }

    public LibraryDTO(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }



}
