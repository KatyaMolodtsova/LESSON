package com.homework.lesson7;

import java.util.Scanner;

public class School {
    public static void main(String[] args) {

        final String SCHOOL_NAME;
        int colT, colP;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название школы");
        SCHOOL_NAME = scanner.nextLine();

        System.out.println("Введите имя директора");
        String nameD = scanner.nextLine();
        System.out.println("Введите возраст директора");
        int ageD = scanner.nextInt();

        Director director = new Director(nameD, ageD);

        System.out.println("Введите количество учителей");
        colT = scanner.nextInt();

        System.out.println("Введите количество учеников в одном классе");
        colP = scanner.nextInt();

        People[] arrayPupil = new Pupil[colP];
        People[] arrayTeacher = new Teacher[colT];

        for (int i = 0; i < arrayTeacher.length; i++) {
            System.out.println("Введите имя учителя");
            String nameT = scanner.nextLine();
            System.out.println("Введите возраст учителя");
            int ageT = scanner.nextInt();
            arrayTeacher[i] = People.peopleFactory(nameT, ageT);
            System.out.println("Введите предмет учителя");
        }
    }
}
