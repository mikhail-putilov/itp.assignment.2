package ru.innopolis.mputilov.service;

import ru.innopolis.mputilov.domain.schedule_agnostic.AgnosticGroup;
import ru.innopolis.mputilov.domain.schedule_aware.CourseHumansAware;
import ru.innopolis.mputilov.repository.AgnosticGroupRepository;
import ru.innopolis.mputilov.repository.CourseHumansAwareRepository;

import java.util.List;

/**
 * Created by mputilov on 20/10/16.
 */
public class StudentService {
    private AgnosticGroupRepository groupRepository;
    private CourseHumansAwareRepository courseRepository;

    public StudentService(AgnosticGroupRepository groupRepository, CourseHumansAwareRepository courseRepository) {
        this.groupRepository = groupRepository;
        this.courseRepository = courseRepository;
    }

    public void printToBeVisitedCoursesFor(String firstname, String lastname) {
        AgnosticGroup groupWhichContainsStudent = groupRepository
                .findCurrentYearAgnosticGroupByStudent(firstname, lastname);

        List<CourseHumansAware> allCourses = courseRepository.findByGroupCode(groupWhichContainsStudent.getGroupCode());
        for (CourseHumansAware course : allCourses) {
            System.out.println(course);
        }
    }
}
