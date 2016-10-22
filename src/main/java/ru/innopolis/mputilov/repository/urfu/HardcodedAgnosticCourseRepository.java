package ru.innopolis.mputilov.repository.urfu;

import ru.innopolis.mputilov.domain.schedule_agnostic.CourseAgnostic;
import ru.innopolis.mputilov.repository.BaseAgnosticCourseRepository;

import java.util.UUID;

/**
 * Repository of course information without humans association
 * <p>
 * Singleton. Because we can't use spring's singletons.
 * Caution: do not use this in production systems.
 * <p>
 * Created by mputilov on 20/10/16.
 */
public class HardcodedAgnosticCourseRepository extends BaseAgnosticCourseRepository {
    private final static HardcodedAgnosticCourseRepository INSTANCE = new HardcodedAgnosticCourseRepository();

    private HardcodedAgnosticCourseRepository() {
        courses.add(new CourseAgnostic(UUID.randomUUID().toString(), "ItP", "Introduction to Programming. Lorem ipsum dolorem..."));
    }

    public static HardcodedAgnosticCourseRepository getInstance() {
        return INSTANCE;
    }

}
