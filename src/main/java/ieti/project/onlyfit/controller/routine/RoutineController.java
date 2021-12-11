package ieti.project.onlyfit.controller.routine;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ieti.project.onlyfit.repository.document.RoutineFit;
import ieti.project.onlyfit.service.routine.RoutineService;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/routine")
public class RoutineController {
    
    private final RoutineService routineService;

    public RoutineController(@Autowired RoutineService routineService){
        this.routineService = routineService;
    }

    @GetMapping
    public ResponseEntity<?> all(){
        return ResponseEntity.ok(routineService.all());
    }

    @GetMapping("/email")
    @ResponseBody
    public List<RoutineFit> getRoutineByCoachEmail(@RequestParam(name = "emailAddress", value = "emailAddress") String email){
        return routineService.findRoutineByCoachEmail(email);
    }

    @PostMapping
    public ResponseEntity<RoutineFit> create(@RequestBody RoutineDto routineDto){
        return ResponseEntity.ok(routineService.create(routineDto));
    }

    @PutMapping( "/{id}")
    public ResponseEntity<RoutineFit> update (@RequestBody RoutineDto routineDto, @PathVariable String id ){
        return ResponseEntity.ok(routineService.update(routineDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        return ResponseEntity.ok(routineService.deleteById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoutineFit> getRoutineById(@PathVariable String id){
        return ResponseEntity.ok(routineService.getRoutineById(id));
    }

}
