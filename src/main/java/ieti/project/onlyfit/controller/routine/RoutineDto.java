package ieti.project.onlyfit.controller.routine;

public class RoutineDto {
    String name;
    String description;
    String purpose;
    String emailCoach;
    boolean payment;

    public RoutineDto(){

    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getPurpose(){
        return purpose;
    }

    public String getEmailCoach(){
        return emailCoach;
    }

    public boolean getPayment(){
        return payment;
    }
}
