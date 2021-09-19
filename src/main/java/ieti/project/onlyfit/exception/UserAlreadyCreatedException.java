package ieti.project.onlyfit.exception;

import ieti.project.onlyfit.error.ErrorCodeEnum;
import ieti.project.onlyfit.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class UserAlreadyCreatedException extends InternalServerErrorException {

    public UserAlreadyCreatedException()
    {
        super( new ServerErrorResponseDto( "User already created", ErrorCodeEnum.USER_ALREADY_CREATED, HttpStatus.NOT_FOUND ),
                HttpStatus.NOT_FOUND );
    }
}
