package ieti.project.onlyfit.service.user;

import ieti.project.onlyfit.controller.user.UserDto;
import ieti.project.onlyfit.exception.UserAlreadyCreatedException;
import ieti.project.onlyfit.exception.UserNotFoundException;
import ieti.project.onlyfit.repository.UserRepository;
import ieti.project.onlyfit.repository.document.RoleEnum;
import ieti.project.onlyfit.repository.document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB
    implements UserService
{

    private final UserRepository userRepository;

    public UserServiceMongoDB( @Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create(UserDto userDto )
    {
        if(!userRepository.existsByEmail(userDto.getEmail())){
            return userRepository.save( new User( userDto ) );
        }else{
            throw new UserAlreadyCreatedException();
        }
    }

    @Override
    public User findById( String id )
    {
        Optional<User> optionalUser = userRepository.findById( id );
        if ( optionalUser.isPresent() )
        {
            return optionalUser.get();
        }
        else
        {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User findByEmail( String email )
        throws UserNotFoundException
    {
        Optional<User> optionalUser = userRepository.findByEmail( email );
        if ( optionalUser.isPresent() )
        {
            return optionalUser.get();
        }
        else
        {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<User> all()
    {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById( String id )
    {
        if ( userRepository.existsById( id ) )
        {
            userRepository.deleteById( id );
            return true;
        }
        return false;
    }

    @Override
    public User update( UserDto userDto, String id )
    {
        if ( userRepository.findById( id ).isPresent() )
        {
            User user = userRepository.findById( id ).get();
            user.update( userDto );
            userRepository.save( user );
            return user;
        }
        return null;
    }

    @Override
    public List<User> allUsers()
    {
        List<User> allUsers = userRepository.findAll();
        List<User> allCoaches = new ArrayList<>();
        for(User user: allUsers){
            if(user.getRoles().get(0) == RoleEnum.valueOf("USER")){
                allCoaches.add(user);
            }
        }
        return allCoaches;
    }


}
