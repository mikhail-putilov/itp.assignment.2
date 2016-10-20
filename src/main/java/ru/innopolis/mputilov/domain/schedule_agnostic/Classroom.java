package ru.innopolis.mputilov.domain.schedule_agnostic;

/**
 * Created by mputilov on 25.08.16.
 */
public class Classroom {
    private String classroomCode;
    private String description = "";
    private String floor = "";

    public Classroom(String classroomCode) {
        this.classroomCode = classroomCode;
    }

    public Classroom(String classroomCode, String floor) {
        this(classroomCode);
        this.floor = floor;
    }

    public Classroom(String classroomCode, String floor, String description) {
        this(classroomCode, floor);
        this.description = description;
    }

    public String getFloor() {
        return floor;
    }

    public String getClassroomCode() {
        return classroomCode;
    }

    public String getDescription() {
        return description;
    }
}
