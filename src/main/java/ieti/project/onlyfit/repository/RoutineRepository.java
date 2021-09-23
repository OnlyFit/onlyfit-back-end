package ieti.project.onlyfit.repository;

import java.util.List;
import ieti.project.onlyfit.repository.document.RoutineFit;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoutineRepository extends MongoRepository<RoutineFit,String> {

    @Query("{ 'emailCoach': ?0 }")
    List<RoutineFit> findByCoachEmail(String email);
}
