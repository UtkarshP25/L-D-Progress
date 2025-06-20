package com.utkarsh.bookmanager.Entity;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Book {

    @Min(value = 1, message = "ID must be greater than or equal to 1")
    private int id;

    @NotBlank(message = "Title must not be blank")
    private String title;

    @NotBlank(message = "Author must not be blank")
    private String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
