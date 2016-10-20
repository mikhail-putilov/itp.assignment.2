package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.CourseAgnostic;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Repository of course information without humans association
 * <p>
 * Singleton. Because we can't use spring's singletons.
 * Caution: do not use this in production systems.
 * <p>
 * Created by mputilov on 20/10/16.
 */
public class HardcodedAgnosticCourseRepository {
    private final static HardcodedAgnosticCourseRepository INSTANCE = new HardcodedAgnosticCourseRepository();
    private List<CourseAgnostic> courses = new ArrayList<>();

    private HardcodedAgnosticCourseRepository() {
        courses.add(new CourseAgnostic(UUID.randomUUID().toString(), "ItP", "Introduction to Programming. Lorem ipsum dolorem..."));
    }

    public static HardcodedAgnosticCourseRepository getInstance() {
        return INSTANCE;
    }

    public CourseAgnostic findCourseByCode(String courseCode) {
        return courses.stream().filter(courseAgnostic -> courseAgnostic.getCourseCode().equals(courseCode)).findAny().get();
    }
}
