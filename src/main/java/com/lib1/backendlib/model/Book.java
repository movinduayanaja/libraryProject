package com.lib1.backendlib.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books") // If Hibernate is creating the table in Option B, you can remove this line or keep it.
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 255)
    private String author;

    @Column(length = 100)
    private String genre;

    @Column(length = 50)
    private String language;

    @Column(length = 13, unique = true)
    private String isbn;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 9)
    private Status status = Status.AVAILABLE;

    @Column(name = "image_url", length = 512)
    private String imageUrl;

    @Column(name = "category_id")
    private Integer categoryId;

    public enum Status { AVAILABLE, RESERVED }

    // Getters & setters
    public Integer getId() { return id; } public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; } public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; } public void setAuthor(String author) { this.author = author; }
    public String getGenre() { return genre; } public void setGenre(String genre) { this.genre = genre; }
    public String getLanguage() { return language; } public void setLanguage(String language) { this.language = language; }
    public String getIsbn() { return isbn; } public void setIsbn(String isbn) { this.isbn = isbn; }
    public Status getStatus() { return status; } public void setStatus(Status status) { this.status = status; }
    public String getImageUrl() { return imageUrl; } public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public Integer getCategoryId() { return categoryId; } public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
}