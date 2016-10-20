package ru.innopolis.mputilov.domain.schedule_aware;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by mputilov on 20/10/16.
 */
public class Schedule {

    Set<ScheduleEntry> oneTimeEntries = new TreeSet<>();

    public void addOneTimeEntry(ScheduleEntry scheduleEntry) {
        oneTimeEntries.add(scheduleEntry);
    }

    public void addRepetitiveEntry(ScheduleEntry scheduleEntry) {
        throw new RuntimeException("Is not implemented");
    }
}
