package com.example.api.quote;

import java.time.LocalDate;

public class Quote {
    private Long id;
    private String quote;
    private String author;
    private LocalDate publishedDate;

    public Quote() {

    }

    public Quote(Long id, String quote, String author, LocalDate publishedDate) {
        this.id = id;
        this.quote = quote;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public Quote(String quote, String author, LocalDate publishedDate) {
        this.quote = quote;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "Quote{" + "id: " + id + "quote " + quote;
    }

}
