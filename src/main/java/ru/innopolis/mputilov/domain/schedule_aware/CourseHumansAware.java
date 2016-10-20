package ru.innopolis.mputilov.domain.schedule_aware;

import ru.innopolis.mputilov.domain.DomainObject;
import ru.innopolis.mputilov.domain.schedule_agnostic.AgnosticGroup;
import ru.innopolis.mputilov.domain.schedule_agnostic.CourseAgnostic;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.Instructor;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.TeacherAssistant;

import java.util.List;

/**
 * Associated course with humans. One course per group. And associated TA's.
 * <p>
 * Created by mputilov on 25.08.16.
 */
public class CourseHumansAware extends DomainObject {
    private CourseAgnostic courseAgnostic;
    private AgnosticGroup enrolledAgnosticGroup;
    private List<Instructor> primaryInstructors;
    private List<TeacherAssistant> teacherAssistants;

    public CourseHumansAware(String courseId,
                             CourseAgnostic courseAgnostic,
                             AgnosticGroup enrolledAgnosticGroup,
                             List<Instructor> primaryInstructors,
                             List<TeacherAssistant> teacherAssistants) {
        super(courseId);
        this.courseAgnostic = courseAgnostic;
        this.enrolledAgnosticGroup = enrolledAgnosticGroup;
        this.primaryInstructors = primaryInstructors;
        this.teacherAssistants = teacherAssistants;
    }

    public List<Instructor> getPrimaryInstructors() {
        return primaryInstructors;
    }

    public void setPrimaryInstructors(List<Instructor> primaryInstructors) {
        this.primaryInstructors = primaryInstructors;
    }

    public List<TeacherAssistant> getTeacherAssistants() {
        return teacherAssistants;
    }

    public void setTeacherAssistants(List<TeacherAssistant> teacherAssistants) {
        this.teacherAssistants = teacherAssistants;
    }

    public AgnosticGroup getEnrolledAgnosticGroup() {
        return enrolledAgnosticGroup;
    }

    public void setEnrolledGroup(AgnosticGroup enrolledAgnosticGroup) {
        this.enrolledAgnosticGroup = enrolledAgnosticGroup;
    }

    public CourseAgnostic getCourseAgnostic() {
        return courseAgnostic;
    }

    public void setCourseAgnostic(CourseAgnostic courseAgnostic) {
        this.courseAgnostic = courseAgnostic;
    }
}
