package ru.innopolis.mputilov;

import ru.innopolis.mputilov.domain.schedule_agnostic.Classroom;
import ru.innopolis.mputilov.domain.schedule_aware.CourseHumansAware;
import ru.innopolis.mputilov.domain.schedule_aware.Schedule;
import ru.innopolis.mputilov.domain.schedule_aware.ScheduleEntry;
import ru.innopolis.mputilov.repository.innopolis.HardcodedClassroomRepository;
import ru.innopolis.mputilov.repository.innopolis.HardcodedCourseHumansAwareRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.util.UUID.randomUUID;
import static ru.innopolis.mputilov.Main.LOCAL_DATE_27_10_2016;

/**
 * Created by mputilov on 22/10/16.
 */
public class HardcodedInnopolisSchedule {
    private final static HardcodedCourseHumansAwareRepository COURSE_HUMANS_AWARE_REPOSITORY = HardcodedCourseHumansAwareRepository.getInstance();
    private static final HardcodedClassroomRepository CLASSROOM_REPOSITORY = HardcodedClassroomRepository.getInstance();

    /**
     * First part of the assignment: ''Take your own teaching schedule AND the schedule of the last year
     * (see it in Moodle) and fill your system implemented earlier with the information taken from these two sources''
     *
     * @return sample innopolis schedule
     */
    public static Schedule scheduleApiDemo() {
        //example of using schedule's api:
        CourseHumansAware itpAwareMs1_3 = COURSE_HUMANS_AWARE_REPOSITORY.findByCourseCodeAndGroupCode("ItP", "MS1-3");
        CourseHumansAware itpAwareMs1_1 = COURSE_HUMANS_AWARE_REPOSITORY.findByCourseCodeAndGroupCode("ItP", "MS1-1");


        Classroom classroom108 = CLASSROOM_REPOSITORY.findByClassroomCode("108");
        Classroom classroom109 = CLASSROOM_REPOSITORY.findByClassroomCode("109");
        Classroom classroom110 = CLASSROOM_REPOSITORY.findByClassroomCode("110");


        Schedule schedule = new Schedule();
        // default lecture
        LocalDateTime at10_30 = LocalDateTime.of(LOCAL_DATE_27_10_2016, LocalTime.of(10, 30));
        LocalDateTime at12_00 = LocalDateTime.of(LOCAL_DATE_27_10_2016, LocalTime.of(12, 0));
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

}
