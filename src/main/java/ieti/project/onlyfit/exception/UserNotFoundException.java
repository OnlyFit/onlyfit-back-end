package ieti.project.onlyfit.exception;

import ieti.project.onlyfit.error.ErrorCodeEnum;
import ieti.project.onlyfit.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException
    extends InternalServerErrorException
{
    public UserNotFoundException()
    {
        super( new ServerErrorResponseDto( "User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND ),
               HttpStatus.NOT_FOUND );
    }
}
