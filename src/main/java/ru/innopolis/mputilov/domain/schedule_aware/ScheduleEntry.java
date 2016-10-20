package ru.innopolis.mputilov.domain.schedule_aware;

import ru.innopolis.mputilov.domain.DomainObject;
import ru.innopolis.mputilov.domain.schedule_agnostic.Classroom;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Teacher;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.TeacherAssistant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mputilov on 20/10/16.
 */
public class ScheduleEntry extends DomainObject implements Comparable<ScheduleEntry> {
    private CourseHumansAware what;
    private Classroom where;
    private LocalDateTime when;

    private List<? extends Teacher> teachers = new ArrayList<>(); //substitute teachers maybe?

    private ScheduleEntry(String id, CourseHumansAware what, Classroom where, LocalDateTime when) {
        super(id);
        this.what = what;
        this.where = where;
        this.when = when;
    }

    /**
     * @param scheduleEntryId unique id
     * @param what            subject with associated group and its instructor and TAs
     * @param where           classroom
     * @param when            when it is going to start
     * @param teachers        what exact teachers is going to give a lecture for this associated group of students
     */
    private ScheduleEntry(String scheduleEntryId,
                          CourseHumansAware what,
                          Classroom where,
                          LocalDateTime when,
                          List<Teacher> teachers) {
        this(scheduleEntryId, what, where, when);
        this.teachers = teachers;
    }

    public static ScheduleEntry createTaLesson(String id, CourseHumansAware what, Classroom where, LocalDateTime when) {
        ScheduleEntry entry = new ScheduleEntry(id, what, where, when);
        entry.setTeachers(what.getTeacherAssistants());
        return entry;
    }

    public static ScheduleEntry createInstructorLesson(String id, CourseHumansAware what, Classroom where, LocalDateTime when) {
        ScheduleEntry entry = new ScheduleEntry(id, what, where, when);
        entry.setTeachers(what.getPrimaryInstructors());
        return entry;
    }

    public static ScheduleEntry createLessonWithSubstitutedTeacher(String id, CourseHumansAware what, Classroom where, LocalDateTime when, List<Teacher> substitutes) {
        ScheduleEntry entry = new ScheduleEntry(id, what, where, when);
        entry.setTeachers(substitutes);
        return entry;
    }

    public CourseHumansAware getWhat() {
        return what;
    }

    public void setWhat(CourseHumansAware what) {
        this.what = what;
    }

    public Classroom getWhere() {
        return where;
    }

    public void setWhere(Classroom where) {
        this.where = where;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }

    public List<? extends Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<? extends Teacher> teachers) {
        this.teachers = teachers;
    }

    /**
     * Compare by time, by group code, by course code
     *
     * @param o other scheduleEntry
     * @return default compare result
     */
    @Override
    public int compareTo(ScheduleEntry o) {
        int cmpWhen = when.compareTo(o.getWhen());
        if (cmpWhen != 0) return cmpWhen;

        int cmpGroupCode = what.getEnrolledAgnosticGroup().getGroupCode().compareTo(o.getWhat().getEnrolledAgnosticGroup().getGroupCode());
        if (cmpGroupCode != 0) return cmpGroupCode;

        int cmpCourseCode = what.getCourseAgnostic().getCourseCode().compareTo(o.getWhat().getCourseAgnostic().getCourseCode());
        if (cmpCourseCode != 0) return cmpCourseCode;

        return 0;
    }
}
