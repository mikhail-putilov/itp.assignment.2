package ru.innopolis.mputilov.university;

/**
 * Created by mputilov on 25.08.16.
 */
public class Classroom {
    private String classroomCode;
    private String description;

    public Classroom(String classroomCode, String description) {
        this.classroomCode = classroomCode;
        this.description = description;
    }

    public String getClassroomCode() {
        return classroomCode;
    }

    public String getDescription() {
        return description;
    }
}
