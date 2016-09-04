package ru.innopolis.mputilov.university;

import java.util.List;

/**
 * Created by mputilov on 25.08.16.
 */
public class Course {
    private String courseId; // unique id
    private List<Student> enrolledStudent;
    private String courseCode; // COM-DJ
    private Classroom classroom;

    public Course(String courseId, List<Student> enrolledStudent, String courseCode, Classroom classroom) {
        this.courseId = courseId;
        this.enrolledStudent = enrolledStudent;
        this.courseCode = courseCode;
        this.classroom = classroom;
    }

    public String getCourseId() {
        return courseId;
    }

    public List<Student> getEnrolledStudent() {
        return enrolledStudent;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Classroom getClassroom() {
        return classroom;
    }
}
