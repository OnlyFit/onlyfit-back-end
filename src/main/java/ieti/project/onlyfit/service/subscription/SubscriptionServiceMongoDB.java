package ieti.project.onlyfit.service.subscription;

import ieti.project.onlyfit.controller.subscription.SubscriptionDto;
import ieti.project.onlyfit.repository.SubscriptionRepository;
import ieti.project.onlyfit.repository.UserRepository;
import ieti.project.onlyfit.repository.document.Subscription;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceMongoDB implements SubscriptionService {
  private final SubscriptionRepository subscriptionRepository;

  public SubscriptionServiceMongoDB(
    @Autowired SubscriptionRepository subscriptionRepository
  ) {
    this.subscriptionRepository = subscriptionRepository;
  }

  @Override
  public Subscription create(SubscriptionDto subscriptionDto) {
    return subscriptionRepository.save(new Subscription(subscriptionDto));
  }

  @Override
  public Subscription update(
    SubscriptionDto subscriptionDto,
    String userEmail
  ) {
    if (subscriptionRepository.findByEmail(userEmail).isPresent()) {
      Subscription subscription = subscriptionRepository
        .findByEmail(userEmail)
        .get();
      subscription.update(subscriptionDto);
      subscriptionRepository.save(subscription);

      return subscription;
    }

    return null;
  }

  @Override
  public List<Subscription> all() {
    return subscriptionRepository.findAll();
  }

  @Override
  public Subscription findByEmail(String email) {
    Optional<Subscription> optionalSubscription = subscriptionRepository.findByEmail(
      email
    );
    if (optionalSubscription.isPresent()) {
      return optionalSubscription.get();
    } else {
        return null;
    }
  }
}
