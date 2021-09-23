package ieti.project.onlyfit.service.user;

import ieti.project.onlyfit.controller.user.UserDto;
import ieti.project.onlyfit.exception.UserNotFoundException;
import ieti.project.onlyfit.repository.document.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface UserService
{
    User create(UserDto userDto );

    User findById( String id )
        throws UserNotFoundException;

    User findByEmail( String email )
        throws UserNotFoundException;

    ArrayList<User> findByName (String name )
        throws UserNotFoundException;

    List<User> all();

    boolean deleteById( String id );

    User update( UserDto userDto, String id );

    List<User> allUsers();
}
