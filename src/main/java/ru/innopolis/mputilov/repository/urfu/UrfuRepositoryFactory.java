package ru.innopolis.mputilov.repository.urfu;

import ru.innopolis.mputilov.repository.ClassroomRepository;
import ru.innopolis.mputilov.repository.CourseHumansAwareRepository;
import ru.innopolis.mputilov.repository.RepositoryFactory;

/**
 * Created by mputilov on 22/10/16.
 */
public class UrfuRepositoryFactory implements RepositoryFactory {
    @Override
    public CourseHumansAwareRepository createCourseHumansAwareRepository() {
        return ru.innopolis.mputilov.repository.urfu.HardcodedCourseHumansAwareRepository.getInstance();
    }

    @Override
    public ClassroomRepository createHardcodedClassroomRepository() {
        return HardcodedClassroomRepository.getInstance();
    }
}
