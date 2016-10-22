package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.CourseAgnostic;

/**
 * Created by mputilov on 22/10/16.
 */
public interface AgnosticCourseRepository {
    CourseAgnostic findCourseByCode(String courseCode);
}
