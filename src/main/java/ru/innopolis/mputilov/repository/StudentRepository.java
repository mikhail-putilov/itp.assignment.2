package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Student;

/**
 * Created by mputilov on 22/10/16.
 */
public interface StudentRepository {
    Student findByFirstAndLastName(String firstName, String lastName);
}
