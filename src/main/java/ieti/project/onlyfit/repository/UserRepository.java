package ieti.project.onlyfit.repository;

import ieti.project.onlyfit.repository.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.*;
import java.util.Optional;

public interface UserRepository
    extends MongoRepository<User, String>
{
    Optional<User> findByEmail( String email );
    Optional<User> findByName( String name );
    boolean existsByEmail(String email);
}
