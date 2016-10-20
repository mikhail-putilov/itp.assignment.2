package ru.innopolis.mputilov;

import ru.innopolis.mputilov.domain.schedule_agnostic.Classroom;
import ru.innopolis.mputilov.domain.schedule_aware.CourseHumansAware;
import ru.innopolis.mputilov.domain.schedule_aware.Schedule;
import ru.innopolis.mputilov.domain.schedule_aware.ScheduleEntry;
import ru.innopolis.mputilov.repository.HardcodedClassroomRepository;
import ru.innopolis.mputilov.repository.HardcodedCourseHumansAwareRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.util.UUID.randomUUID;

/**
 * Created by mputilov on 31.08.16.
 */
public class Main {
    private final static HardcodedCourseHumansAwareRepository COURSE_HUMANS_AWARE_REPOSITORY = HardcodedCourseHumansAwareRepository.getInstance();
    private static final HardcodedClassroomRepository CLASSROOM_REPOSITORY = HardcodedClassroomRepository.getInstance();
    public static final LocalDate LOCAL_DATE = LocalDate.of(2016, 10, 27);


    public static void main(String[] args) {
        //see schedule api demonstration
        Schedule schedule = scheduleApiDemo();
        queriesDemo(schedule);
    }

    private static void queriesDemo(Schedule schedule) {
        System.out.println("Schedule for MS1-3 at " + LOCAL_DATE + ":");
        schedule.printScheduleFor("MS1-3", LOCAL_DATE);
        System.out.println("====");
        System.out.println("Schedule for everyone at " + LOCAL_DATE + ":");
        schedule.printScheduleAt(LOCAL_DATE);
    }

    /**
     * First part of the assignment: ''Take your own teaching schedule AND the schedule of the last year
     * (see it in Moodle) and fill your system implemented earlier with the information taken from these two sources''
     *
     * @return sample innopolis schedule
     */
    private static Schedule scheduleApiDemo() {
        //example of using schedule's api:
        CourseHumansAware itpAwareMs1_3 = COURSE_HUMANS_AWARE_REPOSITORY.findByCourseCodeAndGroupCode("ItP", "MS1-3");
        CourseHumansAware itpAwareMs1_1 = COURSE_HUMANS_AWARE_REPOSITORY.findByCourseCodeAndGroupCode("ItP", "MS1-1");


        Classroom classroom108 = CLASSROOM_REPOSITORY.findByClassroomCode("108");
        Classroom classroom109 = CLASSROOM_REPOSITORY.findByClassroomCode("109");
        Classroom classroom110 = CLASSROOM_REPOSITORY.findByClassroomCode("110");


        Schedule schedule = new Schedule();
        // default lecture
        LocalDateTime at10_30 = LocalDateTime.of(LOCAL_DATE, LocalTime.of(10, 30));
        LocalDateTime at12_00 = LocalDateTime.of(LOCAL_DATE, LocalTime.of(12, 0));
        ScheduleEntry ordinaryLessonMs1_1 = ScheduleEntry.createInstructorLesson(randomUUID().toString(), itpAwareMs1_1, classroom108, at10_30);
        ScheduleEntry ordinaryLessonMs1_3 = ScheduleEntry.createInstructorLesson(randomUUID().toString(), itpAwareMs1_3, classroom108, at10_30);
        schedule.addOneTimeEntry(ordinaryLessonMs1_1);
        schedule.addOneTimeEntry(ordinaryLessonMs1_3);
        //lab lessons
        ScheduleEntry labLessonMs1_1 = ScheduleEntry.createTaLesson(randomUUID().toString(), itpAwareMs1_1, classroom110, at10_30);
        ScheduleEntry labLessonMs1_3 = ScheduleEntry.createTaLesson(randomUUID().toString(), itpAwareMs1_3, classroom109, at12_00);
        schedule.addOneTimeEntry(labLessonMs1_1);
        schedule.addOneTimeEntry(labLessonMs1_3);
        return schedule;
    }

//        example of repository API:
//        Student studentMikhailPutilov = STUDENT_REPOSITORY.findByFirstAndLastName("Mikhail", "Putilov");
//        TeacherAssistant taMaratMingazov = TA_REPOSITORY.findByFirstAndLastName("Marat", "Mingazov");
//        AgnosticGroup ms1_3 = AGNOSTIC_GROUP_REPOSITORY.findCurrentYearAgnosticGroupByGroupCode("MS1-3");
//        CourseAgnostic itpCourse = AGNOSTIC_COURSE_REPOSITORY.findByClassroomCode("ItP");
}
