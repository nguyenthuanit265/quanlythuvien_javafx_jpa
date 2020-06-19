package com.quanlythuvien.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String category;
    String author;
    String publisher;
    String yearPublished;
    String ISBN;

    public Book() {
    }

    public Book(int id, String name, String category, String author, String publisher, String yearPublished, String ISBN) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.ISBN = ISBN;
    }

    public Book(String name, String category, String author, String publisher, String yearPublished, String ISBN) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.ISBN = ISBN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearPublished='" + yearPublished + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}

