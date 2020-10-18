package com.control.control1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Logger {

    public static Abonement addAboment(){
        Scanner scanner = new Scanner(System.in);

        // создадим посетителя
        String name, surname, gender, strDateBirth, tipeAb, numberAb;
        LocalDate dateBirth;

        System.out.println("Введите данные о посетителе.");
        System.out.println("Введите имя посетителя:");
        name = scanner.nextLine();
        System.out.println("Введите фамилию посетителя:");
        surname = scanner.nextLine();
        System.out.println("Введите пол посетителя:");
        gender = scanner.nextLine();
        System.out.println("Введите дату рождения посетителя в формате ДД.ММ.ГГГГ :");
        strDateBirth = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        dateBirth = LocalDate.parse(strDateBirth, dtf);

        Visitor visitor = new Visitor(name, surname, gender, dateBirth);

        // создадим абонемент
        System.out.println("Выберите тип абонемента: разовый абонемент, дневной абонемент, полный абонемент.");
        tipeAb = scanner.nextLine();
        System.out.println("Введите номер абонемента:");
        numberAb = scanner.nextLine();
        Abonement abonement = new Abonement(visitor, tipeAb, numberAb);

        return abonement;
    }

    public static String[] training(){
        Scanner scanner = new Scanner(System.in);

        String[] array = new String[2];

        System.out.println("Введите данные об абонементе, по которому проходите на тренировку и выберите зону.");
        System.out.println("Введите номер абонемента:");
        array[0] = scanner.nextLine();
        System.out.println("Введите желаемую зону тренировки: бассейн, тренажерный зал, групповые занятия");
        array[1] = scanner.nextLine();

        return array;
    }
}
