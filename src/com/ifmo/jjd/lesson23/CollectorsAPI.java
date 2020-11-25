package com.ifmo.jjd.lesson23;

import com.ifmo.jjd.lesson22.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsAPI {
    public static void main(String[] args) {

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());

        // группировки Collectors.groupingBy()
        // название - список курсов
        // ключ - название курса
        // значение - список курсов
        Map<String, List<Course>> byName = courses.stream()
                // создает мапу с ключами какого-то типа и списком какого-то типа, передается параметр группировки
                .collect(Collectors.groupingBy(Course::getName)); // course -> course.getName()
                // не нравится List, нужна другая коллекция, в groupingBy еще один параметр
                // .collect(Collectors.groupingBy(Course::getName, Collectors.toCollection(ArrayList::new));

        // название - количество курсов
        Map<String, Long> corsesCount = courses.stream()
                // по умолчанию группирует по какой-то характеристике в список
                // Collectors.counting() считает, сколько объектов с указанным именем
                .collect(Collectors.groupingBy(Course::getName, Collectors.counting()));

        // название - средняя стоимость
        Map<String, Double> coursesAvPrice = courses.stream()
                .collect(Collectors.groupingBy(Course::getName,
                        Collectors.averagingDouble(Course::getPrice)));

        // ключ - название, значение - мапа. у мапы ключ - продолжительность, значение - список курсов
        Map<String, Map<Integer, List<Course>>> nameDuration = courses.stream()
                .collect(Collectors.groupingBy(Course::getName,
                        Collectors.groupingBy(Course::getDuration))); // правила формирования значения

        List<String> coursesName = courses.stream()
                .map(Course::getName) //  course -> course.getName() - принимает курс, а возвращает имя курса
                .distinct()
                .sorted()
                .collect(Collectors.toList());

    }
}
