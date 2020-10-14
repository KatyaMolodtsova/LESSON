package com.ifmo.jjd.lesson9;

import java.util.Objects;

public class App {
    public static void main(String[] args) {
        Author ivan = new Author("Иван", "Петров");
        Author anna = new Author("Анна", "Гришкова");

        ColouringBook cars = new ColouringBook("Машинки", 23, 15);
        cars.setAuthor(ivan);

        ColouringBook robots = new ColouringBook("Роботы", 38, 19);
        robots.setAuthor(ivan);

        ColouringBook flowers = new ColouringBook("Цветы", 12, 10);
        flowers.setAuthor(anna);

        // Все классы наследуются от Object
        // Object obj = new Object();
        // Object author = new Author("Иван", "Петров"); // теряет все свои методы

        // toString()
        System.out.println(ivan.toString());

        // equals() и hashCode() используются для сравнения объектов
        Author author1 = new Author("Михаил", "Петров");
        Author author2 = new Author("Михаил", "Петров");

        // == сравнивает ссылки на объект
        System.out.println(author1 == author2); // false
        // метод equals() используется лдя сравнения объектов
        System.out.println(author1.equals(author2)); // false // true после переоопределения

        // equals()
        // 1. объект всегда равен самому себе (рефлективность)
        // 2. если a.equals(b), то b.equals(a) (симметричность)
        // 2.1. если a.equals(b), b.equals(a), то a.equals(c) (транзитивность)
        // 3. сколько бы раз не вызывался equals без изменения состояния объекта, результат должен
        // оставаться неизменным (консистентность)
        // hashCode()
        // 1. если объекты равны по equals, то hashCode должен вернуть одинаковое значение для обоих объектов
        // 2. если объекты не равны по equals, то hashCode может вернуть одинаковое значение для обоих объектов
        // 3. сколько бы раз не вызывался hashCode без изменения состояния объекта, результат должен
        // оставаться неизменным
        // Objects.hash(picsCount) вернет hashCode объекта

        ColouringBook colouring1 = new ColouringBook("Роботы", 38, 19);
        colouring1.setAuthor(ivan);

        ColouringBook colouring2 = new ColouringBook("Роботы", 38, 19);
        colouring2.setAuthor(ivan);

        System.out.println(colouring1.equals(colouring2)); // false

        // clone()
        // модификатор доступа protected
        // возвращает Object
        // super.clone() реализация по умолчанию - клонирует только свойства класса, не создает копии объектов
        // super.clone() обязан выбрасывать ошибку throws CloneNotSupportedException

        ivan = new Author("Иван", "Петров");
        // Author copyIvan = ivan.clone();
        colouring1.clone();



        Objects.requireNonNull(null, "Not NULL");
        Objects.requireNonNull(null);
        // посмотреть класс Objects
    }
}
