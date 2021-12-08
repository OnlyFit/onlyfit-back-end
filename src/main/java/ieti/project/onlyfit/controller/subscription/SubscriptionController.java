package ieti.project.onlyfit.controller.subscription;

import ieti.project.onlyfit.repository.document.Subscription;
import ieti.project.onlyfit.service.subscription.SubscriptionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/subscription")
public class SubscriptionController {
  private final SubscriptionService subscriptionService;

  public SubscriptionController(
    @Autowired SubscriptionService subscriptionService
  ) {
    this.subscriptionService = subscriptionService;
  }

  @GetMapping
  public List<Subscription> all() {
    return subscriptionService.all();
  }

  @GetMapping("/{email}")
  public Subscription findByEmail(@PathVariable String email) {
    return subscriptionService.findByEmail(email);
  }

  @PostMapping
  public ResponseEntity<Subscription> create(
    @RequestBody SubscriptionDto subscriptionDto
  ) {
    return ResponseEntity.ok(subscriptionService.create(subscriptionDto));
  }

  @PutMapping
  public ResponseEntity<Subscription> update(
    @RequestBody SubscriptionDto subscriptionDto,
    @PathVariable String email
  ) {
    return ResponseEntity.ok(
      subscriptionService.update(subscriptionDto, email)
    );
  }
}
