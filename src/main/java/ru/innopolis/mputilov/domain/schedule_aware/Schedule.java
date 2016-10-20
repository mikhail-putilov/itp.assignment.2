package ru.innopolis.mputilov.domain.schedule_aware;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

import static ru.innopolis.mputilov.domain.schedule_aware.Schedule.Pair.of;


/**
 * Created by mputilov on 20/10/16.
 */
public class Schedule {
    private TreeSet<Pair> oneTimeEntries = new TreeSet<>();

    public void addOneTimeEntry(ScheduleEntry scheduleEntry) {
        oneTimeEntries.add(of(scheduleEntry));
    }
//    private Set<ScheduleEntry> repetitiveEntries = new ...

//    public void addRepetitiveEntry(ScheduleEntry scheduleEntry) {
//        throw new RuntimeException("Is not implemented");
//    }

    public void printScheduleFor(String groupCode, LocalDate when) {
        SortedSet<Pair> pairs = oneTimeEntries.subSet(
                of(LocalDateTime.of(when, LocalTime.MIN), groupCode, null),
                of(LocalDateTime.of(when, LocalTime.MAX), groupCode, null));
        pairs.forEach(pair -> System.out.println(pair.entry));
    }

    static class Pair implements Comparable<Pair> {
        private ScheduleEntry entry;
        private LocalDateTime when;
        private String groupCode;
        private String courseCode;

        public static Pair of(LocalDateTime when, String groupCode, String courseCode) {
            Pair pair = new Pair();
            pair.when = when;
            pair.groupCode = groupCode;
            pair.courseCode = courseCode;
            return pair;
        }

        public static Pair of(ScheduleEntry entry) {
            Pair pair = new Pair();
            pair.entry = entry;
            pair.when = entry.getWhen();
            pair.groupCode = entry.getWhat().getEnrolledAgnosticGroup().getGroupCode();
            pair.courseCode = entry.getWhat().getCourseAgnostic().getCourseCode();
            return pair;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(when, pair.when) &&
                    Objects.equals(groupCode, pair.groupCode) &&
                    Objects.equals(courseCode, pair.courseCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(when, groupCode, courseCode);
        }

        /**
         * Compare by time, by group code, by course code
         *
         * @param o other pair
         * @return default compare result
         */
        @Override
        public int compareTo(Pair o) {
            int cmpWhen = when.compareTo(o.when);
            if (cmpWhen != 0) return cmpWhen;

            int cmpGroupCode = groupCode.compareTo(o.groupCode);
            if (cmpGroupCode != 0) return cmpGroupCode;

            int cmpCourseCode = courseCode.compareTo(o.courseCode);
            if (cmpCourseCode != 0) return cmpCourseCode;

            return 0;
        }

    }
}
