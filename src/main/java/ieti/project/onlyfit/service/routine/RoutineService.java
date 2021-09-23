package ieti.project.onlyfit.service.routine;

import java.util.List;

import ieti.project.onlyfit.controller.routine.RoutineDto;
import ieti.project.onlyfit.repository.document.Routine;

public interface RoutineService {

    Routine create(RoutineDto routineDto);
    List<Routine> all();
    boolean deleteById(String id);
    Routine update(RoutineDto routineDto, String id);
    List<Routine> findRoutineByCoachEmail(String email);
    
}
