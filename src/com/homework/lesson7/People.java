package com.homework.lesson7;

abstract public class People {
    protected String name;
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public static People peopleFactory(String name, int age) {
//        People people = new People(name, age);
//        return people;
//    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
