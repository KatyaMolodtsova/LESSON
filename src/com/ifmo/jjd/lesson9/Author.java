package com.ifmo.jjd.lesson9;

import java.util.Objects;

public class Author {
    private String name;
    private String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false; // является объектом данного типа

        Author author = (Author) o; // явное приведение

        return Objects.equals(name, author.name) &&
                Objects.equals(surname, author.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
    public Author clone() throws CloneNotSupportedException { // приведение типа
        return (Author) super.clone();
    }
}