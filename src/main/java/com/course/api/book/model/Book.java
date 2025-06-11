package com.course.api.book.model;

import java.util.Objects;

public class Book {

    private Long id;
    private String name;
    private int numberOfDownloads;

    public Book() {
    }

    public Book(Long id, String name, int numberOfDownloads) {
        this.id = id;
        this.name = name;
        this.numberOfDownloads = numberOfDownloads;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return numberOfDownloads == book.numberOfDownloads && Objects.equals(id, book.id) && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfDownloads);
    }
}
