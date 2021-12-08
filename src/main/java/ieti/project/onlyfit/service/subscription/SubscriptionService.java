package ieti.project.onlyfit.service.subscription;

import ieti.project.onlyfit.controller.subscription.SubscriptionDto;
import ieti.project.onlyfit.repository.document.Subscription;
import java.util.List;

public interface SubscriptionService {
    Subscription create(SubscriptionDto subscriptionDto);
    Subscription update(SubscriptionDto subscriptionDto, String userEmail);
    List<Subscription> all();
    Subscription findByEmail(String email);
}
