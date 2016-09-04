package ru.innopolis.mputilov.university;

import java.util.List;

/**
 * Created by mputilov on 25.08.16.
 */
public class Instructor {
    private FullName fullName;
    private String instructorId;
    private List<Course> givenCourses;

    public Instructor(String instructorId, FullName fullName, List<Course> givenCourses) {
        this.fullName = fullName;
        this.instructorId = instructorId;
        this.givenCourses = givenCourses;
    }

    public FullName getFullName() {
        return fullName;
    }

    public List<Course> getGivenCourses() {
        return givenCourses;
    }

    public String getInstructorId() {
        return instructorId;
    }
}
