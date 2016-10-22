package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.humans.FullName;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mputilov on 22/10/16.
 */
public abstract class BaseStudentRepository {
    protected List<Student> students = new ArrayList<>();

    public Student findByFirstAndLastName(String firstName, String lastName) {
        FullName fullName = new FullName(firstName, lastName);
        return students.stream().filter(student -> student.getFullName().equals(fullName)).findAny().get();
    }
}
