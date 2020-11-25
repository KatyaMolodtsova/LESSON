package com.ifmo.jjd.lesson22;

import java.util.Objects;

public class Course {
    private int price;
    private int duration;
    private final String name;

    public Course(String name, int duration, int price) {
        this.price = price;
        this.duration = duration;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "price=" + price +
                ", duration=" + duration +
                ", name='" + name + '\'' +
                '}';
    }

    public static Course getInstance() {
        String[] names = {"JJD", "Node js", "Python", "C++"};
        return new Course(
                names[(int) (Math.random() * names.length)],
                (int) ((Math.random() * 4) + 1),
                (int) (Math.random() * 50000) + 10000
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return price == course.price &&
                duration == course.duration &&
                Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, duration, name);
    }
}