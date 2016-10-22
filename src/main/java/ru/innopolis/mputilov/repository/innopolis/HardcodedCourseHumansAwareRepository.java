package ru.innopolis.mputilov.repository.innopolis;

import ru.innopolis.mputilov.domain.schedule_agnostic.AgnosticGroup;
import ru.innopolis.mputilov.domain.schedule_agnostic.CourseAgnostic;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Instructor;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.TeacherAssistant;
import ru.innopolis.mputilov.domain.schedule_aware.CourseHumansAware;

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
public class HardcodedCourseHumansAwareRepository extends ru.innopolis.mputilov.repository.BaseCourseHumansAwareRepository {
    private final static HardcodedCourseHumansAwareRepository INSTANCE = new HardcodedCourseHumansAwareRepository();

    private HardcodedCourseHumansAwareRepository() {
        CourseAgnostic itpCourse = HardcodedAgnosticCourseRepository.getInstance().findCourseByCode("ItP");
        Instructor instructorEugeneZuev = HardcodedInstructorRepository.getInstance().findByFirstAndLastName("Eugene", "Zuev");
        AgnosticGroup ms1_3 = HardcodedAgnosticGroupRepository.getInstance().findCurrentYearAgnosticGroupByGroupCode("MS1-3");
        AgnosticGroup ms1_1 = HardcodedAgnosticGroupRepository.getInstance().findCurrentYearAgnosticGroupByGroupCode("MS1-1");
        TeacherAssistant taMaratMingazov = HardcodedTeacherAssistantRepository.getInstance().findByFirstAndLastName("Marat", "Mingazov");
        //Игорь Престолов передает Джораху Мормонту пламенный привет
        TeacherAssistant taJorahMormont = HardcodedTeacherAssistantRepository.getInstance().findByFirstAndLastName("Jorah", "Mormont");

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

}
