package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_aware.CourseHumansAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by mputilov on 22/10/16.
 */
public abstract class BaseCourseHumansAwareRepository {
    protected List<CourseHumansAware> courseHumansAwareList = new ArrayList<>();

    public CourseHumansAware findByCourseCodeAndGroupCode(String courseCode, String groupCode) {
        return courseHumansAwareList.stream()
                .filter(course -> Objects.equals(course.getCourseAgnostic().getCourseCode(), courseCode)
                        && Objects.equals(course.getEnrolledAgnosticGroup().getGroupCode(), groupCode))
                .findAny()
                .get();
    }

    public List<CourseHumansAware> findByGroupCode(String groupCode) {
        return courseHumansAwareList.stream()
                .filter(course -> Objects.equals(course.getEnrolledAgnosticGroup().getGroupCode(), groupCode))
                .collect(Collectors.toList());
    }
}
