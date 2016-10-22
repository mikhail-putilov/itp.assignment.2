package ru.innopolis.mputilov.repository;

/**
 * Created by mputilov on 22/10/16.
 */
public interface RepositoryFactory {
    CourseHumansAwareRepository createCourseHumansAwareRepository();

    ClassroomRepository createHardcodedClassroomRepository();
}
