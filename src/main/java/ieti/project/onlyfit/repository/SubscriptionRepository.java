package ieti.project.onlyfit.repository;

import ieti.project.onlyfit.repository.document.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
    Optional<Subscription> findByEmail(String email);
}
