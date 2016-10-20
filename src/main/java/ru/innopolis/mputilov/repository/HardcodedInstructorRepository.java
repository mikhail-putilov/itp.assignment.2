package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.humans.FullName;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Instructor's repository
 * <p>
 * Singleton. Because we can't use spring's singletons.
 * Caution: do not use this in production systems.
 * <p>
 * Created by mputilov on 20/10/16.
 */
public class HardcodedInstructorRepository {
    private final static HardcodedInstructorRepository INSTANCE = new HardcodedInstructorRepository();
    private List<Instructor> instructors = new ArrayList<>();

    private HardcodedInstructorRepository() {
        instructors.add(new Instructor(UUID.randomUUID().toString(), new FullName("Eugene", "Zuev")));
    }

    public static HardcodedInstructorRepository getInstance() {
        return INSTANCE;
    }

    public Instructor findByFirstAndLastName(String firstName, String lastName) {
        FullName fullName = new FullName(firstName, lastName);
        return instructors.stream().filter(instructor -> instructor.getFullName().equals(fullName)).findAny().get();
    }
}
