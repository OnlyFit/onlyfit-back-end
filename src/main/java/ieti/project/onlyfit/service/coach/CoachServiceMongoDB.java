package ieti.project.onlyfit.service.coach;

import ieti.project.onlyfit.repository.UserRepository;
import ieti.project.onlyfit.repository.document.RoleEnum;
import ieti.project.onlyfit.repository.document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoachServiceMongoDB implements CoachService{

    private final UserRepository userRepository;

    public CoachServiceMongoDB( @Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> allCoaches()
    {
        List<User> allUsers = userRepository.findAll();
        List<User> allCoaches = new ArrayList<>();
        for(User user: allUsers){
            if(user.getRoles().get(0) == RoleEnum.valueOf("COACH")){
                allCoaches.add(user);
            }
        }
        return allCoaches;
    }

}
