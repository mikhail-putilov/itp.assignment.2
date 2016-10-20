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
import ru.innopolis.mputilov.repository.HardcodedInstructorRepository;
import ru.innopolis.mputilov.repository.HardcodedStudentRepository;
import ru.innopolis.mputilov.repository.HardcodedTeacherAssistantRepository;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.UUID.randomUUID;

/**
 * Created by mputilov on 31.08.16.
 */
public class Main {
    private static HardcodedStudentRepository studentRepository = new HardcodedStudentRepository();
    private static HardcodedTeacherAssistantRepository taRepository = new HardcodedTeacherAssistantRepository();
    private static HardcodedInstructorRepository instructorRepository = new HardcodedInstructorRepository();

    public static void main(String[] args) {
        // humans
        Student studentMikhailPutilov = studentRepository.findByFirstAndLastName("Mikhail", "Putilov");
        Student studentMartinGarrix = studentRepository.findByFirstAndLastName("Martin", "Garrix");
        Student studentStanislavMikhel = studentRepository.findByFirstAndLastName("Stanislav", "Mikhel");

        TeacherAssistant taMaratMingazov = taRepository.findByFirstAndLastName("Marat", "Mingazov");
        TeacherAssistant taJorahMormont = taRepository.findByFirstAndLastName("Jorah", "Mormont");
        Instructor instructorEugeneZuev = instructorRepository.findByFirstAndLastName("Eugene", "Zuev");

        //group ms1-3
        AgnosticGroup ms1_3 = new AgnosticGroup(randomUuid(), "MS1-3", Year.now(), asList(studentMikhailPutilov, studentStanislavMikhel));
        AgnosticGroup ms1_1 = new AgnosticGroup(randomUuid(), "MS1-1", Year.now(), singletonList(studentMartinGarrix));
        //course itp
        CourseAgnostic itpCourse = new CourseAgnostic(randomUuid(), "ItP", "Introduction to Programming. Lorem ipsum dolorem...");
        CourseHumansAware itpAwareMs1_3 = new CourseHumansAware(randomUuid(), itpCourse, ms1_3,
                singletonList(instructorEugeneZuev),
                singletonList(taMaratMingazov));
        CourseHumansAware itpAwareMs1_1 = new CourseHumansAware(randomUuid(), itpCourse, ms1_1,
                singletonList(instructorEugeneZuev),
                singletonList(taJorahMormont));



        Classroom classroom108 = new Classroom("108", "1th floor");
        Classroom classroom109 = new Classroom("109", "1th floor");
        Classroom classroom110 = new Classroom("110", "1th floor");


        Schedule schedule = new Schedule();
        // default lecture
        ScheduleEntry ordinaryLessonMs1_1 = ScheduleEntry.createInstructorLesson(randomUuid(), itpAwareMs1_1, classroom108, LocalDateTime.of(2016, 10, 20, 10, 30));
        ScheduleEntry ordinaryLessonMs1_3 = ScheduleEntry.createInstructorLesson(randomUuid(), itpAwareMs1_3, classroom108, LocalDateTime.of(2016, 10, 20, 10, 30));
        schedule.addOneTimeEntry(ordinaryLessonMs1_1);
        schedule.addOneTimeEntry(ordinaryLessonMs1_3);
        //lab lessons
        ScheduleEntry labLessonMs1_1 = ScheduleEntry.createTaLesson(randomUuid(), itpAwareMs1_1, classroom110, LocalDateTime.of(2016, 10, 27, 10, 30));
        ScheduleEntry labLessonMs1_3 = ScheduleEntry.createTaLesson(randomUuid(), itpAwareMs1_3, classroom109, LocalDateTime.of(2016, 10, 27, 12, 30));
        schedule.addOneTimeEntry(labLessonMs1_1);
        schedule.addOneTimeEntry(labLessonMs1_3);
    }

    private static String randomUuid() {
        return randomUUID().toString();
    }
}
