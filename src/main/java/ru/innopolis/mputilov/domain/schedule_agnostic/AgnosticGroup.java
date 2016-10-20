package ru.innopolis.mputilov.domain.schedule_agnostic;

import ru.innopolis.mputilov.domain.DomainObject;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Student;

import java.time.Year;
import java.util.List;

/**
 * Created by mputilov on 25.08.16.
 */
public class AgnosticGroup extends DomainObject {
    private String groupCode;
    private Year yearOfCreation;
    private List<Student> students;

    public AgnosticGroup(String groupId, String groupCode, Year yearOfFormation, List<Student> students) {
        super(groupId);
        this.groupCode = groupCode;
        this.yearOfCreation = yearOfFormation;
        this.students = students;
    }

    public String getGroupCode() {
        return groupCode;
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
