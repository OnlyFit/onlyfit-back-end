package ieti.project.onlyfit.service.coach;

import ieti.project.onlyfit.repository.document.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CoachService {
    List<User> allCoaches();
}
