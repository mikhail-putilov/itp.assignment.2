package ru.innopolis.mputilov.repository.urfu;

import ru.innopolis.mputilov.domain.schedule_agnostic.AgnosticGroup;
import ru.innopolis.mputilov.domain.schedule_agnostic.CourseAgnostic;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Instructor;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.TeacherAssistant;
import ru.innopolis.mputilov.domain.schedule_aware.CourseHumansAware;
import ru.innopolis.mputilov.repository.BaseCourseHumansAwareRepository;

import static java.util.Collections.emptyList;
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
public class HardcodedCourseHumansAwareRepository extends BaseCourseHumansAwareRepository {
    private final static HardcodedCourseHumansAwareRepository INSTANCE = new HardcodedCourseHumansAwareRepository();

    private HardcodedCourseHumansAwareRepository() {
        HardcodedAgnosticGroupRepository groupRepository = HardcodedAgnosticGroupRepository.getInstance();

        CourseAgnostic itpCourse = HardcodedAgnosticCourseRepository.getInstance().findCourseByCode("Calculus");
        Instructor instructor = HardcodedInstructorRepository.getInstance().findByFirstAndLastName("Maxim", "Alshanskyi");
        AgnosticGroup p100901 = groupRepository.findCurrentYearAgnosticGroupByGroupCode("p-100901");
        AgnosticGroup p100902 = groupRepository.findCurrentYearAgnosticGroupByGroupCode("p-100902");

        courseHumansAwareList.add(new CourseHumansAware(randomUUID().toString(), itpCourse, p100901,
                singletonList(instructor),
                emptyList()));
        courseHumansAwareList.add(new CourseHumansAware(randomUUID().toString(), itpCourse, p100902,
                singletonList(instructor),
                emptyList()));
    }

    public static HardcodedCourseHumansAwareRepository getInstance() {
        return INSTANCE;
    }

}
