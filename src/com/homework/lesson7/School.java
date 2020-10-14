package com.homework.lesson7;

import java.util.Scanner;

public class School {

    final private String SCHOOL_NAME;
    private Director director;
    final private Teacher[] teachers = new Teacher[4];
    final private Pupil[] pupils = new Pupil[8];

    public School(String SCHOOL_NAME, Director director) {
        this.SCHOOL_NAME = SCHOOL_NAME;
        this.director = director;
    }

    public void passDay(){
        director.startOfClasses();

        for (Teacher teacher : teachers) {
            if (teacher != null) {
                for (Pupil pupil : pupils) {
                    if (pupil != null && pupil.getSubject().equalsIgnoreCase(teacher.getSubjectTaught()))
                        teacher.teach(pupil);
                }
            }
        }

        director.endOfClasses();
    }

}
