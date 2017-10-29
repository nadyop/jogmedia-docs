package com.Jogmedia.Jogmedia.model;

import java.math.BigDecimal;

public class Book {

    private int book_id;

    private String isbn, book_title, author, publisher, location;
    private double price_after, price_before, discount;
    public Book(){}
    public Book(String isbn, String book_title, String author, String publisher, String location, double price_after, double price_before, double discount) {
        this.isbn = isbn;
        this.book_title = book_title;
        this.author = author;
        this.publisher = publisher;
        this.location = location;
        this.price_after = price_after;
        this.price_before = price_before;
        this.discount = discount;
    }


    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice_after() {
        return price_after;
    }

    public void setPrice_after(double price_after) {
        this.price_after = price_after;
    }

    public double getPrice_before() {
        return price_before;
    }

    public void setPrice_before(double price_before) {
        this.price_before = price_before;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
