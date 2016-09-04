package ru.innopolis.mputilov;

import ru.innopolis.mputilov.university.*;

import java.time.Year;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.UUID.randomUUID;

/**
 * Created by mputilov on 31.08.16.
 */
public class Main {
    public static void main(String[] args) {
        Group group = new Group(randomUUID().toString(), "MS1-3", Year.now(), emptyList());
        Student studentPutilov = new Student(randomUUID().toString(), new FullName("Mikhail", "Putilov"), "Computer science", "MS1", "MS1", group);
        Classroom classroom1 = new Classroom("314", "Roman auditory");
        Course courseComDj = new Course(randomUUID().toString(), emptyList(), "COM-DJ", classroom1);
        Instructor instructorAlexander = new Instructor(randomUUID().toString(), new FullName("Alexander", "Klimchuk"), singletonList(courseComDj));
    }
}
