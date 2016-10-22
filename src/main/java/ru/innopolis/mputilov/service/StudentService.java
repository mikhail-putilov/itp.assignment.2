package ru.innopolis.mputilov.service;

import ru.innopolis.mputilov.domain.schedule_agnostic.AgnosticGroup;
import ru.innopolis.mputilov.domain.schedule_aware.CourseHumansAware;
import ru.innopolis.mputilov.repository.innopolis.HardcodedAgnosticGroupRepository;
import ru.innopolis.mputilov.repository.innopolis.HardcodedCourseHumansAwareRepository;

import java.util.List;

/**
 * Created by mputilov on 20/10/16.
 */
public class StudentService {

    private static final StudentService INSTANCE = new StudentService();

    public static StudentService getInstance() {
        return INSTANCE;
    }

    public void printToBeVisitedCoursesFor(String firstname, String lastname) {
        AgnosticGroup groupWhichContainsStudent = HardcodedAgnosticGroupRepository.getInstance()
                .findCurrentYearAgnosticGroupByStudent(firstname, lastname);

        List<CourseHumansAware> allCourses = HardcodedCourseHumansAwareRepository.getInstance().findByGroupCode(groupWhichContainsStudent.getGroupCode());
        for (CourseHumansAware course : allCourses) {
            System.out.println(course);
        }
    }
}
