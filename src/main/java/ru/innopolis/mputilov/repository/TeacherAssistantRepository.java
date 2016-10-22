package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.humans.TeacherAssistant;

/**
 * Created by mputilov on 22/10/16.
 */
public interface TeacherAssistantRepository {
    TeacherAssistant findByFirstAndLastName(String firstName, String lastName);
}
