package com.ifmo.jjd.control1;

import java.nio.channels.AlreadyConnectedException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Visitor {
    private String name, surname, gender, strDateBirth;
    private LocalDate dateBirth;

    public Visitor(String name, String surname, String gender, LocalDate dateBirth) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        // приходит String вида "dd.mm.yyyy", сохраняем в dateBirth типа LocalDate
        setDateBirth(strDateBirth);
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

    private void setDateBirth(String strDateBirth) {
        if (strDateBirth == Constants.NULLDATE) throw new IllegalArgumentException("Не указана дата рождения посетителя");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.dateBirth = LocalDate.parse(strDateBirth, formatter);
    }
}
