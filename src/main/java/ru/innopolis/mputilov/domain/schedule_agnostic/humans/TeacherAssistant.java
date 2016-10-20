package ru.innopolis.mputilov.domain.schedule_agnostic.humans;

import ru.innopolis.mputilov.domain.DomainObject;

/**
 * Created by mputilov on 20/10/16.
 */
public class TeacherAssistant extends DomainObject implements Teacher {
    private FullName fullName;

    @Override
    public String toString() {
        return "TeacherAssistant{" +
                "fullName=" + fullName +
                '}';
    }

    public TeacherAssistant(String taId, FullName fullName) {
        super(taId);
        this.fullName = fullName;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }
}
