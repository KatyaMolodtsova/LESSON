package com.ifmo.jjd.lesson11;
import java.time.LocalDate;
import java.util.Objects;

public class Article {
    private final String title;
    private String text;
    private final LocalDate created;
    private Country country;

    public Article(String title) {
        this.title = title;
        created = LocalDate.now();
    }

    public void setCountry(Country country) {
        Objects.requireNonNull(country, "country");
        this.country = country;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Country getCountry() {
        return country;
    }
}
