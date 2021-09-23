package ieti.project.onlyfit.repository.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ieti.project.onlyfit.controller.routine.RoutineDto;

@Document
public class Routine {
    @Id
    String id;

    String name;

    String description;
    
    String purpose;

    String emailCoach;

    boolean payment;

    public Routine(){

    }

    public Routine(RoutineDto routineDto){
        name = routineDto.getName();
        description = routineDto.getDescription();
        purpose = routineDto.getPurpose();
        emailCoach = routineDto.getEmailCoach();
        payment = routineDto.getPayment();
    }

    public void update(RoutineDto routineDto){
        name = routineDto.getName();
        description = routineDto.getDescription();
        purpose = routineDto.getPurpose();
        emailCoach = routineDto.getEmailCoach();
        payment = routineDto.getPayment();
    }
}
