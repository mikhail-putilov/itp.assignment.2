package ru.innopolis.mputilov.repository.urfu;

import ru.innopolis.mputilov.domain.schedule_agnostic.Classroom;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository of course information without humans association
 * <p>
 * Singleton. Because we can't use spring's singletons.
 * Caution: do not use this in production systems.
 * <p>
 * Created by mputilov on 20/10/16.
 */
public class HardcodedClassroomRepository extends ru.innopolis.mputilov.repository.BaseClassroomRepository {
    private final static HardcodedClassroomRepository INSTANCE = new HardcodedClassroomRepository();

    private HardcodedClassroomRepository() {
        classrooms.add(new Classroom("101", "1th floor"));
        classrooms.add(new Classroom("201", "2th floor"));
        classrooms.add(new Classroom("301", "3th floor", "Small room"));
    }

    public static HardcodedClassroomRepository getInstance() {
        return INSTANCE;
    }

}
