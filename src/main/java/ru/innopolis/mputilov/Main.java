package ru.innopolis.mputilov;

import ru.innopolis.mputilov.domain.schedule_agnostic.AgnosticGroup;
import ru.innopolis.mputilov.domain.schedule_agnostic.Classroom;
import ru.innopolis.mputilov.domain.schedule_agnostic.CourseAgnostic;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.FullName;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Instructor;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Student;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.TeacherAssistant;
import ru.innopolis.mputilov.domain.schedule_aware.CourseHumansAware;
import ru.innopolis.mputilov.domain.schedule_aware.Schedule;
import ru.innopolis.mputilov.domain.schedule_aware.ScheduleEntry;

import java.time.LocalDateTime;
import java.time.Year;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.UUID.randomUUID;

/**
 * Created by mputilov on 31.08.16.
 */
public class Main {
    public static void main(String[] args) {
        // humans
        Student studentMikhailPutilov = new Student(randomUuid(), new FullName("Mikhail", "Putilov"), "Computer science");
        Student studentStanislavMikhel = new Student(randomUuid(), new FullName("Stanislav", "Mikhel"), "Computer science");
        TeacherAssistant taMaratMingazov = new TeacherAssistant(randomUuid(), new FullName("Marat", "Mingazov"));
        TeacherAssistant taJorahMormont = new TeacherAssistant(randomUuid(), new FullName("Jorah", "Mormont"));
        Instructor instructorEugeneZuev = new Instructor(randomUuid(), new FullName("Eugene", "Zuev"));

        //group ms1-3
        AgnosticGroup ms1_3 = new AgnosticGroup(randomUuid(), "MS1-3", Year.now(), asList(studentMikhailPutilov, studentStanislavMikhel));
        //course itp
        CourseAgnostic itpCourse = new CourseAgnostic(randomUuid(), "ItP", "Introduction to Programming. Lorem ipsum dolorem...");
        CourseHumansAware itpHumansAware = new CourseHumansAware(randomUuid(), itpCourse, ms1_3,
                singletonList(instructorEugeneZuev),
                singletonList(taMaratMingazov));


        Classroom classroom108 = new Classroom("108", "1th floor");

        Schedule schedule = new Schedule();
        ScheduleEntry ordinaryLesson = ScheduleEntry.createInstructorLesson(randomUuid(), itpHumansAware, classroom108, LocalDateTime.of(2016, 10, 20, 10, 30));
        schedule.addOneTimeEntry(ordinaryLesson);
        ScheduleEntry labLesson = ScheduleEntry.createTaLesson(randomUuid(), itpHumansAware, classroom108, LocalDateTime.of(2016, 10, 27, 10, 30));
        schedule.addOneTimeEntry(labLesson);
    }

    private static String randomUuid() {
        return randomUUID().toString();
    }
}
