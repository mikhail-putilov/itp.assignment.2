package ru.innopolis.mputilov.university;

import java.time.Year;
import java.util.List;

/**
 * Created by mputilov on 25.08.16.
 */
public class Group {
    private String groupCode;
    private String groupId;
    private Year yearOfCreation;
    private List<Student> students;

    public Group(String groupId, String groupCode, Year yearOfCreation, List<Student> students) {
        this.groupCode = groupCode;
        this.groupId = groupId;
        this.yearOfCreation = yearOfCreation;
        this.students = students;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public String getGroupId() {
        return groupId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Year getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(Year yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public boolean isStudentInGroup(Student student) {
        return students.contains(student);
    }
}
