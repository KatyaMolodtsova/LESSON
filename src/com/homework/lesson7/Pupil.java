package com.homework.lesson7;

public class Pupil extends People implements StudyAble{
    protected String subject;
    protected int level;

    public Pupil(String name, int age) {
        super(name, age);
    }

    @Override
    public void study(People pupil, People teacher, int level, String subject, String subjectTaught) {

    }
}
