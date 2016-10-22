package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.Classroom;

/**
 * Created by mputilov on 22/10/16.
 */
public interface ClassroomRepository {
    Classroom findByClassroomCode(String classroomCode);
}
