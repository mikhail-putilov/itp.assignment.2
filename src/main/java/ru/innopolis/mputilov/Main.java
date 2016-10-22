package ru.innopolis.mputilov;

import ru.innopolis.mputilov.domain.schedule_aware.Schedule;
import ru.innopolis.mputilov.repository.urfu.HardcodedAgnosticGroupRepository;
import ru.innopolis.mputilov.repository.urfu.HardcodedCourseHumansAwareRepository;
import ru.innopolis.mputilov.service.StudentService;

import java.time.LocalDate;


/**
 * Created by mputilov on 31.08.16.
 */
public class Main {
    public static final LocalDate LOCAL_DATE_27_10_2016 = LocalDate.of(2016, 10, 27);
    public static final StudentService innopolisStudentsService =
            new StudentService(ru.innopolis.mputilov.repository.innopolis.HardcodedAgnosticGroupRepository.getInstance(),
                    ru.innopolis.mputilov.repository.innopolis.HardcodedCourseHumansAwareRepository.getInstance());
    public static final StudentService urfuStudentsService =
            new StudentService(HardcodedAgnosticGroupRepository.getInstance(),
                    HardcodedCourseHumansAwareRepository.getInstance());

    public static void main(String[] args) {
        //see schedule api demonstration
        Schedule schedule = HardcodedInnopolisSchedule.scheduleApiDemo();
        queriesDemo(schedule);
    }

    private static void queriesDemo(Schedule schedule) {
        System.out.println("Schedule for MS1-3 at " + LOCAL_DATE_27_10_2016 + ":");
        schedule.printScheduleFor("MS1-3", LOCAL_DATE_27_10_2016);
        System.out.println("====");
        System.out.println("Schedule for everyone at " + LOCAL_DATE_27_10_2016 + ":");
        schedule.printScheduleAt(LOCAL_DATE_27_10_2016);
        System.out.println("====");
        System.out.println("Student Mikhail Putilov have to visit following courses:");
        innopolisStudentsService.printToBeVisitedCoursesFor("Mikhail", "Putilov");
    }
}
