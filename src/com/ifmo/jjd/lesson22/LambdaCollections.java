package com.ifmo.jjd.lesson22;

import java.util.Comparator;

public class LambdaCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());

        System.out.println(university.getCourses());

        // компараторы
        // реализация метода compare(T o1, T o2), возвращает int
        Comparator<Course> byName = (c1, c2) -> c2.getName().compareTo(c1.getName());
        university.getCourses().sort(byName);

        // принимает на вход объект типа Function, по какому свойству будет производиться сравнение
        byName = Comparator.comparing(course -> course.getName());

        byName = Comparator.comparing(Course::getName);
        // возьмет два объекта, для каждого объекта getName
        university.getCourses().sort(byName);

        university.getCourses().sort(
                Comparator.comparing(Course::getName) //
                .thenComparing(Course::getDuration)
                .thenComparing(Course::getPrice));

        // удалить, если продолжительность < 2
        university.getCourses().removeIf(course -> course.getDuration() < 2);
        university.getCourses().forEach(System.out::println);
        university.getCourses().forEach(course -> course.setDuration(666));
    }
}
