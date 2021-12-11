package ieti.project.onlyfit.service.routine;

import java.util.List;
import java.util.Optional;

import ieti.project.onlyfit.exception.RoutinesNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ieti.project.onlyfit.controller.routine.RoutineDto;
/* import ieti.project.onlyfit.exception.RoutinesNotFoundExeption; */
import ieti.project.onlyfit.repository.RoutineRepository;
import ieti.project.onlyfit.repository.document.RoutineFit;

@Service
public class RoutineServiceMongoDB implements RoutineService{

    private final RoutineRepository routineRepository;

    public RoutineServiceMongoDB( @Autowired RoutineRepository routineRepository){
        this.routineRepository = routineRepository;
    }

    @Override
    public RoutineFit create(RoutineDto routineDto) {
        RoutineFit routine = new RoutineFit(routineDto);
        routineRepository.save(routine);
        return routine;
    }

    @Override
    public List<RoutineFit> all() {
        List<RoutineFit> routineFitList = routineRepository.findAll();
        return routineFitList;
    }

    @Override
    public boolean deleteById(String id) {
        if ( routineRepository.existsById( id ) )
        {
            routineRepository.deleteById( id );
            return true;
        }
        return false;
    }

    @Override
    public RoutineFit update(RoutineDto routineDto, String id) {
        if ( routineRepository.findById( id ).isPresent() )
        {
            RoutineFit routine = routineRepository.findById( id ).get();
            routine.update( routineDto );
            routineRepository.save( routine );
            return routine;
        }
        return null;
    }

    @Override
    public List<RoutineFit> findRoutineByCoachEmail(String email) {
        List<RoutineFit> listRoutines = routineRepository.findByEmailCoach(email);
        System.out.println(listRoutines);
        return listRoutines;
    }

    @Override
    public RoutineFit getRoutineById(String id) {
        return routineRepository.findRoutineFitById(id);
    }

}
