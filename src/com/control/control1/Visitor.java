package com.control.control1;

import com.control.control1.Constants;

import java.time.LocalDate;

public class Visitor {
    private String name, surname, gender;
    private LocalDate dateBirth;

    public Visitor(String name, String surname, String gender, LocalDate dateBirth) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setDateBirth(dateBirth);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Не указано имя посетителя");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        if (surname == null) throw new IllegalArgumentException("Не указана фамилия посетителя");
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    private void setGender(String gender) {
        if (gender == null) throw new IllegalArgumentException("Не указан пол посетителя");
        if (gender == Constants.MAN) this.gender = Constants.MAN;
        else this.gender = Constants.WOMAN;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    private void setDateBirth(LocalDate dateBirth) {
        if (dateBirth == null) throw new IllegalArgumentException("Не указана дата рождения посетителя");
        this.dateBirth = dateBirth;
    }
}
