package com.homework.lesson7;

public class Teacher extends People implements TeachAble{
    private String subjectTaught;
    private  int subjectLevel;

    public Teacher(String name, int age, String subjectTaught) {
        super(name, age);
        this.subjectTaught = subjectTaught;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    @Override
    public void teach(StudyAble pupil) {
        pupil.study();
    }
}
