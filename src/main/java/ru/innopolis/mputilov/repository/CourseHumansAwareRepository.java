package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_aware.CourseHumansAware;

import java.util.List;

/**
 * Created by mputilov on 22/10/16.
 */
public interface CourseHumansAwareRepository {
    CourseHumansAware findByCourseCodeAndGroupCode(String courseCode, String groupCode);

    List<CourseHumansAware> findByGroupCode(String groupCode);
}
