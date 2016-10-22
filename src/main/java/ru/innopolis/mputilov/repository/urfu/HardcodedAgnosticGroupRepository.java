package ru.innopolis.mputilov.repository.urfu;

import ru.innopolis.mputilov.domain.schedule_agnostic.AgnosticGroup;
import ru.innopolis.mputilov.repository.BaseAgnosticGroupRepository;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.UUID.randomUUID;

/**
 * Repository of group of students
 * <p>
 * Singleton. Because we can't use spring's singletons.
 * Caution: do not use this in production systems.
 * <p>
 * Created by mputilov on 20/10/16.
 */
public class HardcodedAgnosticGroupRepository extends BaseAgnosticGroupRepository {
    private final static HardcodedAgnosticGroupRepository INSTANCE = new HardcodedAgnosticGroupRepository();

    private HardcodedAgnosticGroupRepository() {
        groups.add(new AgnosticGroup(randomUUID().toString(),
                "P-100901", Year.now(),
                asList(HardcodedStudentRepository.getInstance().findByFirstAndLastName("Mikhail", "Putilov"),
                        HardcodedStudentRepository.getInstance().findByFirstAndLastName("Konstantin", "Putin"))));

        groups.add(new AgnosticGroup(randomUUID().toString(),
                "P-100902", Year.now(),
                singletonList(HardcodedStudentRepository.getInstance().findByFirstAndLastName("Sasha", "Ozonov"))));

    }

    public static HardcodedAgnosticGroupRepository getInstance() {
        return INSTANCE;
    }

}
