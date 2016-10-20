package ru.innopolis.mputilov.domain.schedule_agnostic.humans;

import ru.innopolis.mputilov.domain.DomainObject;

/**
 * Created by mputilov on 25.08.16.
 */
public class Student extends DomainObject {
    private FullName fullName;
    private String major;

    public Student(String studentId, FullName fullName, String major) {
        super(studentId);
        this.fullName = fullName;
        this.major = major;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

}
