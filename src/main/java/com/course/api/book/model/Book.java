package com.course.api.book.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int numberOfDownloads;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    List<Author> authors = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "book_language",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "language_name")
    )
    Set<Language> languages = new HashSet<>();

    public Book() {
    }

    public Book(String name, int numberOfDownloads) {
        this.title = name;
        this.numberOfDownloads = numberOfDownloads;
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

    public int getNumberOfDownloads() {
        return numberOfDownloads;
    }

    public void setNumberOfDownloads(int numberOfDownloads) {
        this.numberOfDownloads = numberOfDownloads;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfDownloads == book.numberOfDownloads && Objects.equals(id, book.id) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, numberOfDownloads);
    }
}
