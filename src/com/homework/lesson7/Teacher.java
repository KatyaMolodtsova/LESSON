package com.homework.lesson7;

public class Teacher extends People implements TeachAble{
    protected String subjectTaught;

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach(People teacher, People pupil) {

    }
}
