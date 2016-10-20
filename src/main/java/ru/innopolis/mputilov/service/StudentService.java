package ru.innopolis.mputilov.service;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import ru.innopolis.mputilov.domain.schedule_agnostic.AgnosticGroup;
import ru.innopolis.mputilov.domain.schedule_aware.CourseHumansAware;
import ru.innopolis.mputilov.repository.HardcodedAgnosticGroupRepository;
import ru.innopolis.mputilov.repository.HardcodedCourseHumansAwareRepository;

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
                .findCurrentYearAgnosticGroupWhichContainsFollowingStudent(firstname, lastname);

        List<CourseHumansAware> allCourses = HardcodedCourseHumansAwareRepository.getInstance().findByGroupCode(groupWhichContainsStudent.getGroupCode());
        for (CourseHumansAware course : allCourses) {
            System.out.println(course);
        }
    }
}
