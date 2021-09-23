package ieti.project.onlyfit.service.routine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ieti.project.onlyfit.controller.routine.RoutineDto;
import ieti.project.onlyfit.exception.RoutinesNotFoundExeption;
import ieti.project.onlyfit.repository.RoutineRepository;
import ieti.project.onlyfit.repository.document.Routine;

@Service
public class RoutineServiceMongoDB implements RoutineService{

    private final RoutineRepository routineRepository;

    public RoutineServiceMongoDB( @Autowired RoutineRepository routineRepository){
        this.routineRepository = routineRepository;
    }

    @Override
    public Routine create(RoutineDto routineDto) {
        return routineRepository.save(new Routine(routineDto));
    }

    @Override
    public List<Routine> all() {
        return routineRepository.findAll();
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
    public Routine update(RoutineDto routineDto, String id) {
        if ( routineRepository.findById( id ).isPresent() )
        {
            Routine routine = routineRepository.findById( id ).get();
            routine.update( routineDto );
            routineRepository.save( routine );
            return routine;
        }
        return null;
    }

    /* @Override
    public List<Routine> findRoutineByCoachEmail(String email) {
        List<Routine> listRoutine = routineRepository.findByCoachEmail(email);
        if(!listRoutine.isEmpty()){
            return listRoutine;
        }
        else{
            throw new RoutinesNotFoundExeption();
        }
    } */
    
}
