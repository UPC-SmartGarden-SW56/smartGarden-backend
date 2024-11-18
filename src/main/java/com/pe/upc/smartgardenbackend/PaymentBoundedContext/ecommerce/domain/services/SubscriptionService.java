package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {
    Subscription create(Subscription subscription);

    Optional<Subscription> findById(Long id);

    List<Subscription> findAll();

    void delete(Long id);
    Subscription update(Long id, Subscription subscription);
}
