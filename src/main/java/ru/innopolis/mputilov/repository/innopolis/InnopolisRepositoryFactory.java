package ru.innopolis.mputilov.repository.innopolis;

import ru.innopolis.mputilov.repository.ClassroomRepository;
import ru.innopolis.mputilov.repository.CourseHumansAwareRepository;
import ru.innopolis.mputilov.repository.RepositoryFactory;

/**
 * Created by mputilov on 22/10/16.
 */
public class InnopolisRepositoryFactory implements RepositoryFactory {
    @Override
    public CourseHumansAwareRepository createCourseHumansAwareRepository() {
        return HardcodedCourseHumansAwareRepository.getInstance();
    }

    @Override
    public ClassroomRepository createHardcodedClassroomRepository() {
        return HardcodedClassroomRepository.getInstance();
    }
}
