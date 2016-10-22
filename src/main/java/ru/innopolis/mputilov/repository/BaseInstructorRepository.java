package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.humans.FullName;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Instructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mputilov on 22/10/16.
 */
public abstract class BaseInstructorRepository {
    protected List<Instructor> instructors = new ArrayList<>();

    public Instructor findByFirstAndLastName(String firstName, String lastName) {
        FullName fullName = new FullName(firstName, lastName);
        return instructors.stream().filter(instructor -> instructor.getFullName().equals(fullName)).findAny().get();
    }
}
