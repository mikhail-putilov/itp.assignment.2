package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.humans.FullName;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by mputilov on 20/10/16.
 */
public class HardcodedInstructorRepository {
    private List<Instructor> instructors = new ArrayList<>();

    public HardcodedInstructorRepository() {
        instructors.add(new Instructor(UUID.randomUUID().toString(), new FullName("Eugene", "Zuev")));
    }

    public Instructor findByFirstAndLastName(String firstName, String lastName) {
        FullName fullName = new FullName(firstName, lastName);
        return instructors.stream().filter(instructor -> instructor.getFullName().equals(fullName)).findAny().get();
    }
}
