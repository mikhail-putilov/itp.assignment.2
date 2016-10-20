package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.AgnosticGroup;
import ru.innopolis.mputilov.domain.schedule_agnostic.CourseAgnostic;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Instructor;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.TeacherAssistant;
import ru.innopolis.mputilov.domain.schedule_aware.CourseHumansAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.singletonList;
import static java.util.UUID.randomUUID;

/**
 * Repository of courses which are associated with humans
 * <p>
 * Singleton. Because we can't use spring's singletons.
 * Caution: do not use this in production systems.
 * <p>
 * Created by mputilov on 20/10/16.
 */
public class HardcodedCourseHumansAwareRepository {
    private final static HardcodedCourseHumansAwareRepository INSTANCE = new HardcodedCourseHumansAwareRepository();
    private final static HardcodedAgnosticCourseRepository AGNOSTIC_COURSE_REPOSITORY = HardcodedAgnosticCourseRepository.getInstance();
    private final static HardcodedAgnosticGroupRepository AGNOSTIC_GROUP_REPOSITORY = HardcodedAgnosticGroupRepository.getInstance();
    private final static HardcodedTeacherAssistantRepository TA_REPOSITORY = HardcodedTeacherAssistantRepository.getInstance();
    private final static HardcodedInstructorRepository INSTRUCTOR_REPOSITORY = HardcodedInstructorRepository.getInstance();
    private List<CourseHumansAware> courseHumansAwareList = new ArrayList<>();

    private HardcodedCourseHumansAwareRepository() {
        CourseAgnostic itpCourse = AGNOSTIC_COURSE_REPOSITORY.findCourseByCode("ItP");
        Instructor instructorEugeneZuev = INSTRUCTOR_REPOSITORY.findByFirstAndLastName("Eugene", "Zuev");
        AgnosticGroup ms1_3 = AGNOSTIC_GROUP_REPOSITORY.findCurrentYearAgnosticGroupByGroupCode("MS1-3");
        AgnosticGroup ms1_1 = AGNOSTIC_GROUP_REPOSITORY.findCurrentYearAgnosticGroupByGroupCode("MS1-1");
        TeacherAssistant taMaratMingazov = TA_REPOSITORY.findByFirstAndLastName("Marat", "Mingazov");
        TeacherAssistant taJorahMormont = TA_REPOSITORY.findByFirstAndLastName("Jorah", "Mormont");

        courseHumansAwareList.add(new CourseHumansAware(randomUUID().toString(), itpCourse, ms1_3,
                singletonList(instructorEugeneZuev),
                singletonList(taMaratMingazov)));
        courseHumansAwareList.add(new CourseHumansAware(randomUUID().toString(), itpCourse, ms1_1,
                singletonList(instructorEugeneZuev),
                singletonList(taJorahMormont)));
    }

    public static HardcodedCourseHumansAwareRepository getInstance() {
        return INSTANCE;
    }

    public CourseHumansAware findByCourseCodeAndGroupCode(String courseCode, String groupCode) {
        return courseHumansAwareList.stream()
                .filter(course -> Objects.equals(course.getCourseAgnostic().getCourseCode(), courseCode)
                        && Objects.equals(course.getEnrolledAgnosticGroup().getGroupCode(), groupCode))
                .findAny()
                .get();
    }
}
