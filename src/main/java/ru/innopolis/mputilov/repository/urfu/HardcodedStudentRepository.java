package ru.innopolis.mputilov.repository.urfu;

import ru.innopolis.mputilov.domain.schedule_agnostic.humans.FullName;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Student;

import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.randomUUID;

/**
 * Repository of students
 * <p>
 * Singleton. Because we can't use spring's singletons.
 * Caution: do not use this in production systems.
 * <p>
 * Created by mputilov on 20/10/16.
 */
public class HardcodedStudentRepository extends ru.innopolis.mputilov.repository.BaseStudentRepository {
    private final static HardcodedStudentRepository INSTANCE = new HardcodedStudentRepository();

    private HardcodedStudentRepository() {
        students.add(new Student(randomUUID().toString(), new FullName("Mikhail", "Putilov"), "Computer science"));
        students.add(new Student(randomUUID().toString(), new FullName("Martin", "Garrix"), "Computer science"));
        students.add(new Student(randomUUID().toString(), new FullName("Stanislav", "Mikhel"), "Computer science"));
    }

    public static HardcodedStudentRepository getInstance() {
        return INSTANCE;
    }

}
