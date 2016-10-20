package ru.innopolis.mputilov.domain.schedule_agnostic;

import ru.innopolis.mputilov.domain.DomainObject;

/**
 * Course ItP can be thought as a course that
 * Created by mputilov on 20/10/16.
 */
public class CourseAgnostic extends DomainObject {
    private String courseCode;
    private String description;

    @Override
    public String toString() {
        return "CourseAgnostic{" +
                "courseCode='" + courseCode + '\'' +
                '}';
    }

    public CourseAgnostic(String id, String courseCode, String description) {
        super(id);
        this.courseCode = courseCode;
        this.description = description;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
