package ieti.project.onlyfit.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import ieti.project.onlyfit.repository.document.Routine;

public interface RoutineRepository extends MongoRepository<Routine,String> {
    /* List<Routine> findByCoachEmail(String email); */
}
