package com.homework.lesson7;

public class Pupil extends People implements StudyAble{
    protected String subject;
    protected int level;

    public Pupil(String name, int age) {
        super(name, age);
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void study() {
        this.level++;
    }
}
