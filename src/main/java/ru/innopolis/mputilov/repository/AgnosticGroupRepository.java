package ru.innopolis.mputilov.repository;

import ru.innopolis.mputilov.domain.schedule_agnostic.AgnosticGroup;

/**
 * Created by mputilov on 22/10/16.
 */
public interface AgnosticGroupRepository {
    AgnosticGroup findCurrentYearAgnosticGroupByStudent(String firstname, String lastname);

    AgnosticGroup findCurrentYearAgnosticGroupByGroupCode(String groupCode);
}
