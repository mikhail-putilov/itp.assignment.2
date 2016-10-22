package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.Classroom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mputilov on 22/10/16.
 */
public abstract class BaseClassroomRepository {
    protected List<Classroom> classrooms = new ArrayList<>();

    public Classroom findByClassroomCode(String classroomCode) {
        return classrooms.stream().filter(classroom -> classroom.getClassroomCode().equals(classroomCode)).findAny().get();
    }
}
