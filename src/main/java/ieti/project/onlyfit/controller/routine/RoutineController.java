package ieti.project.onlyfit.controller.routine;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ieti.project.onlyfit.repository.document.Routine;
import ieti.project.onlyfit.service.routine.RoutineService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/routine")
public class RoutineController {
    
    private final RoutineService routineService;

    public RoutineController(@Autowired RoutineService routineService){
        this.routineService = routineService;
    }

    @GetMapping
    public List<Routine> all(){
        return routineService.all();
    }

    @GetMapping("/{email}")
    public List<Routine> getRoutineByCoachEmail(@PathVariable String email){
        return routineService.findRoutineByCoachEmail(email);
    }

    @PostMapping
    public ResponseEntity<Routine> create(@RequestBody RoutineDto routineDto){
        return ResponseEntity.ok( routineService.create(routineDto));
    }

    @PutMapping( "/{id}")
    public ResponseEntity<Routine> update (@RequestBody RoutineDto routineDto, @PathVariable String id ){
        return ResponseEntity.ok(routineService.update(routineDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        return ResponseEntity.ok(routineService.deleteById(id));
    }
}
