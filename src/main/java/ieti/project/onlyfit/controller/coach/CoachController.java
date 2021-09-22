package ieti.project.onlyfit.controller.coach;


import ieti.project.onlyfit.repository.document.User;
import ieti.project.onlyfit.service.coach.CoachService;
import ieti.project.onlyfit.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/v1/coach" )
public class CoachController {

    @Autowired
    CoachService coachService;
    @Autowired
    UserService userService;

    @GetMapping("/coaches")
    public List<User> allCoaches()
    {
        return coachService.allCoaches();
    }




}