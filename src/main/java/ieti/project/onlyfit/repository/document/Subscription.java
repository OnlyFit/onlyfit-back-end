package ieti.project.onlyfit.repository.document;

import ieti.project.onlyfit.controller.subscription.SubscriptionDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Subscription {
    @Id
    String id;

    @Indexed(unique = true)
    String email;

    Date startDate;

    Date finalDate;

    Boolean isActive;

    public  Subscription() {}

    public Subscription(SubscriptionDto subscriptionDto) {
        email = subscriptionDto.getUserEmail();
        startDate = subscriptionDto.getFinalDate();
        isActive = subscriptionDto.getActive();
    }

    public void update(SubscriptionDto subscriptionDto) {
        email = subscriptionDto.getUserEmail();
        startDate = subscriptionDto.getFinalDate();
        isActive = subscriptionDto.getActive();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String userEmail) {
        this.email = userEmail;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
