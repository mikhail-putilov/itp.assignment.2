package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.humans.FullName;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.TeacherAssistant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mputilov on 22/10/16.
 */
public abstract class BaseTeacherAssistantRepository implements TeacherAssistantRepository {
    protected List<TeacherAssistant> tas = new ArrayList<>();

    @Override
    public TeacherAssistant findByFirstAndLastName(String firstName, String lastName) {
        FullName fullName = new FullName(firstName, lastName);
        return tas.stream().filter(ta -> ta.getFullName().equals(fullName)).findAny().get();
    }
}
