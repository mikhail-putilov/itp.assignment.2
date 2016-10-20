package ru.innopolis.mputilov.domain.schedule_agnostic.humans;

import ru.innopolis.mputilov.domain.DomainObject;

/**
 * Created by mputilov on 25.08.16.
 */
public class Instructor extends DomainObject implements Teacher {
    private FullName fullName;

    @Override
    public String toString() {
        return "Instructor{" +
                "fullName=" + fullName +
                '}';
    }

    public Instructor(String instructorId, FullName fullName) {
        super(instructorId);
        this.fullName = fullName;
    }

    public FullName getFullName() {
        return fullName;
    }

}
