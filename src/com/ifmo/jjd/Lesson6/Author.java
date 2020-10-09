package com.ifmo.jjd.Lesson6;

public class Author {
    private String name;
    private String surname;

    // конструктор по умолчанию
    public Author(){}

    // конструктор
    public Author(String name){
        //this.name = name;
        setName(name);
    }

    // конструктор
    public Author(String name, String surname) {
        //this.name = name;
        //this.surname = surname;
        setSurname(surname);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3)
            throw new IllegalArgumentException("name должен быть не меньше 3");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.trim().length() < 3)
            throw new IllegalArgumentException("surname должен быть не меньше 3");
        this.surname = surname;
    }

    public String getFullName(){
        return name + " " + surname;
    }

    // изменение строкового типа объекта
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
