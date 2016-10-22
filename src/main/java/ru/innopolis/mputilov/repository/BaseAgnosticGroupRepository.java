package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.AgnosticGroup;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mputilov on 22/10/16.
 */
public abstract class BaseAgnosticGroupRepository {
    protected List<AgnosticGroup> groups = new ArrayList<>();

    public AgnosticGroup findCurrentYearAgnosticGroupWhichContainsFollowingStudent(String firstname, String lastname) {
        return groups.stream().filter(agnosticGroup ->
                agnosticGroup.isStudentInGroup(firstname, lastname))
                .findFirst().get();
    }

    public AgnosticGroup findCurrentYearAgnosticGroupByGroupCode(String groupCode) {
        return groups.stream().filter(agnosticGroup ->
                agnosticGroup.getYearOfCreation().equals(Year.now()) &&
                        agnosticGroup.getGroupCode().equals(groupCode)).findAny().get();
    }
}
