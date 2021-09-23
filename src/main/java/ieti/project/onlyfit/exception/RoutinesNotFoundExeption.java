package ieti.project.onlyfit.exception;

import org.springframework.http.HttpStatus;

import ieti.project.onlyfit.error.ErrorCodeEnum;
import ieti.project.onlyfit.error.InternalServerErrorException;

public class RoutinesNotFoundExeption extends InternalServerErrorException{

    public RoutinesNotFoundExeption() {
        super(new ServerErrorResponseDto( "Routines not found", ErrorCodeEnum.ROUTINES_NOT_FOUND, HttpStatus.NOT_FOUND ),
        HttpStatus.NOT_FOUND);
    }
    
}
