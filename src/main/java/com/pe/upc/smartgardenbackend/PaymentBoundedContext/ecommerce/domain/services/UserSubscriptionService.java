package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.UserSubscription;

import java.util.List;
import java.util.Optional;

public interface UserSubscriptionService {
    UserSubscription create(UserSubscription userSubscription);

    Optional<UserSubscription> findById(Long id);

    List<UserSubscription> findAll();

    void delete(Long id);

    UserSubscription update(Long id, UserSubscription userSubscription);
}
