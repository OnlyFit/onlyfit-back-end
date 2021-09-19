package ieti.project.onlyfit.service.user;

import ieti.project.onlyfit.controller.user.UserDto;
import ieti.project.onlyfit.exception.UserNotFoundException;
import ieti.project.onlyfit.repository.document.User;

import java.util.List;

public interface UserService
{
    User create(UserDto userDto );

    User findById( String id )
        throws UserNotFoundException;

    User findByEmail( String email )
        throws UserNotFoundException;

    List<User> all();

    boolean deleteById( String id );

    User update( UserDto userDto, String id );

    List<User> allCoaches();
}
