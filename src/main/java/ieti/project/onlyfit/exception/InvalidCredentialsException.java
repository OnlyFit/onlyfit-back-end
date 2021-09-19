package ieti.project.onlyfit.exception;

import ieti.project.onlyfit.error.ErrorCodeEnum;
import ieti.project.onlyfit.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends InternalServerErrorException
{
    public InvalidCredentialsException()
    {
        super( new ServerErrorResponseDto( "Invalid username or password", ErrorCodeEnum.INVALID_USER_CREDENTIALS,
                HttpStatus.UNAUTHORIZED ), HttpStatus.UNAUTHORIZED );
    }
}

