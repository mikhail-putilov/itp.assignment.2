package ru.innopolis.mputilov;

import ru.innopolis.mputilov.domain.schedule_agnostic.Classroom;
import ru.innopolis.mputilov.domain.schedule_aware.CourseHumansAware;
import ru.innopolis.mputilov.domain.schedule_aware.Schedule;
import ru.innopolis.mputilov.domain.schedule_aware.ScheduleEntry;
import ru.innopolis.mputilov.repository.HardcodedCourseHumansAwareRepository;

import java.time.LocalDateTime;

import static java.util.UUID.randomUUID;

/**
 * Created by mputilov on 31.08.16.
 */
public class Main {
    private final static HardcodedCourseHumansAwareRepository COURSE_HUMANS_AWARE_REPOSITORY = HardcodedCourseHumansAwareRepository.getInstance();


    public static void main(String[] args) {
        //example of using schedule's api:
        CourseHumansAware itpAwareMs1_3 = COURSE_HUMANS_AWARE_REPOSITORY.findByCourseCodeAndGroupCode("ItP", "MS1-3");
        CourseHumansAware itpAwareMs1_1 = COURSE_HUMANS_AWARE_REPOSITORY.findByCourseCodeAndGroupCode("ItP", "MS1-1");


        Classroom classroom108 = new Classroom("108", "1th floor");
        Classroom classroom109 = new Classroom("109", "1th floor");
        Classroom classroom110 = new Classroom("110", "1th floor");


        Schedule schedule = new Schedule();
        // default lecture
        ScheduleEntry ordinaryLessonMs1_1 = ScheduleEntry.createInstructorLesson(randomUUID().toString(), itpAwareMs1_1, classroom108, LocalDateTime.of(2016, 10, 20, 10, 30));
        ScheduleEntry ordinaryLessonMs1_3 = ScheduleEntry.createInstructorLesson(randomUUID().toString(), itpAwareMs1_3, classroom108, LocalDateTime.of(2016, 10, 20, 10, 30));
        schedule.addOneTimeEntry(ordinaryLessonMs1_1);
        schedule.addOneTimeEntry(ordinaryLessonMs1_3);
        //lab lessons
        ScheduleEntry labLessonMs1_1 = ScheduleEntry.createTaLesson(randomUUID().toString(), itpAwareMs1_1, classroom110, LocalDateTime.of(2016, 10, 27, 10, 30));
        ScheduleEntry labLessonMs1_3 = ScheduleEntry.createTaLesson(randomUUID().toString(), itpAwareMs1_3, classroom109, LocalDateTime.of(2016, 10, 27, 12, 30));
        schedule.addOneTimeEntry(labLessonMs1_1);
        schedule.addOneTimeEntry(labLessonMs1_3);
    }

//    //    example of repository API:
//    private static void main2(String[] args) {
//        // humans
//        Student studentMikhailPutilov = STUDENT_REPOSITORY.findByFirstAndLastName("Mikhail", "Putilov");
//        Student studentMartinGarrix = STUDENT_REPOSITORY.findByFirstAndLastName("Martin", "Garrix");
//        Student studentStanislavMikhel = STUDENT_REPOSITORY.findByFirstAndLastName("Stanislav", "Mikhel");
//
//        TeacherAssistant taMaratMingazov = TA_REPOSITORY.findByFirstAndLastName("Marat", "Mingazov");
//        TeacherAssistant taJorahMormont = TA_REPOSITORY.findByFirstAndLastName("Jorah", "Mormont");
//        Instructor instructorEugeneZuev = INSTRUCTOR_REPOSITORY.findByFirstAndLastName("Eugene", "Zuev");
//
//        //group ms1-3 and ms1-1
//        AgnosticGroup ms1_3 = AGNOSTIC_GROUP_REPOSITORY.findCurrentYearAgnosticGroupByGroupCode("MS1-3");
//        AgnosticGroup ms1_1 = AGNOSTIC_GROUP_REPOSITORY.findCurrentYearAgnosticGroupByGroupCode("MS1-1");
//        //course itp
//        CourseAgnostic itpCourse = AGNOSTIC_COURSE_REPOSITORY.findCourseByCode("ItP");
//    }
}
