package ieti.project.onlyfit.service.routine;

import java.util.List;
import java.util.Optional;

import ieti.project.onlyfit.controller.routine.RoutineDto;
import ieti.project.onlyfit.repository.document.RoutineFit;

public interface RoutineService {

    RoutineFit create(RoutineDto routineDto);
    List<RoutineFit> all();
    boolean deleteById(String id);
    RoutineFit update(RoutineDto routineDto, String id);
    List<RoutineFit> findRoutineByCoachEmail(String email);
    
}
