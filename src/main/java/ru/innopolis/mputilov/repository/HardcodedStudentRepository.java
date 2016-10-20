package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.humans.FullName;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Student;

import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.randomUUID;

/**
 * Created by mputilov on 20/10/16.
 */
public class HardcodedStudentRepository {
    private List<Student> students = new ArrayList<>();

    public HardcodedStudentRepository() {
        students.add(new Student(randomUUID().toString(), new FullName("Mikhail", "Putilov"), "Computer science"));
        students.add(new Student(randomUUID().toString(), new FullName("Martin", "Garrix"), "Computer science"));
        students.add(new Student(randomUUID().toString(), new FullName("Stanislav", "Mikhel"), "Computer science"));
    }

    public Student findByFirstAndLastName(String firstName, String lastName) {
        FullName fullName = new FullName(firstName, lastName);
        return students.stream().filter(student -> student.getFullName().equals(fullName)).findAny().get();
    }
}
