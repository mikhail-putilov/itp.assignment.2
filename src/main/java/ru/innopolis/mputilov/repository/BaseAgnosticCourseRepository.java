package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.CourseAgnostic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mputilov on 22/10/16.
 */
public abstract class BaseAgnosticCourseRepository implements AgnosticCourseRepository {
    protected List<CourseAgnostic> courses = new ArrayList<>();

    @Override
    public CourseAgnostic findCourseByCode(String courseCode) {
        return courses.stream().filter(courseAgnostic -> courseAgnostic.getCourseCode().equals(courseCode)).findAny().get();
    }
}
