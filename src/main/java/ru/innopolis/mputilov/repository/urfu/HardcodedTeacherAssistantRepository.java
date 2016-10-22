package ru.innopolis.mputilov.repository.urfu;

import ru.innopolis.mputilov.domain.schedule_agnostic.humans.FullName;
import ru.innopolis.mputilov.domain.schedule_agnostic.humans.TeacherAssistant;

import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.randomUUID;

/**
 * Repository of TAs
 * <p>
 * Singleton. Because we can't use spring's singletons.
 * Caution: do not use this in production systems.
 * <p>
 * Created by mputilov on 20/10/16.
 */
public class HardcodedTeacherAssistantRepository extends ru.innopolis.mputilov.repository.BaseTeacherAssistantRepository {
    private final static HardcodedTeacherAssistantRepository INSTANCE = new HardcodedTeacherAssistantRepository();

    private HardcodedTeacherAssistantRepository() {
        tas.add(new TeacherAssistant(randomUUID().toString(), new FullName("Marat", "Mingazov")));
        tas.add(new TeacherAssistant(randomUUID().toString(), new FullName("Jorah", "Mormont")));
    }

    public static HardcodedTeacherAssistantRepository getInstance() {
        return INSTANCE;
    }

}
