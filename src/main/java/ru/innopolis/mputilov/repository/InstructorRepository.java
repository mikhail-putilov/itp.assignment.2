package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Instructor;

/**
 * Created by mputilov on 22/10/16.
 */
public interface InstructorRepository {
    Instructor findByFirstAndLastName(String firstName, String lastName);
}
