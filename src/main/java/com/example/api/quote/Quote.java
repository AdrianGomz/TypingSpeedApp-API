package com.example.api.quote;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Quote {
    @Id
    @SequenceGenerator(name = "quote_sequence", sequenceName = "quote_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String quote;
    private String author;
    private LocalDate publishedDate;
    @Transient
    private String length;

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

    public String getLength() {
        if (quote.length() < 150) {
            return "short";
        } else if (quote.length() < 230) {
            return "medium";
        }
        return "long";
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Quote{" + "id: " + id + "quote " + quote;
    }

}
