package com.ifmo.jjd.lesson22;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {
    private List<Course> courses = new ArrayList<>();

    public boolean addCourse(Course course) {
        return courses.add(Objects.requireNonNull(course));
    }

    public List<Course> getCourses() {
        return courses;
    }

}