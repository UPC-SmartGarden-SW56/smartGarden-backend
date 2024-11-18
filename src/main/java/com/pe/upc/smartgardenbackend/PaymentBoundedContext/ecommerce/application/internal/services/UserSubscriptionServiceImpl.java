package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.application.internal.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.UserSubscription;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services.UserSubscriptionService;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.infrastucture.persistence.jpa.repositories.UserSubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSubscriptionServiceImpl implements UserSubscriptionService {
    private final UserSubscriptionRepository repository;

    public UserSubscriptionServiceImpl(UserSubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserSubscription create(UserSubscription userSubscription) {
        return repository.save(userSubscription);
    }

    @Override
    public Optional<UserSubscription> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<UserSubscription> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("User subscription not found");
        }
        repository.deleteById(id);
    }

    @Override
    public UserSubscription update(Long id, UserSubscription userSubscription) {
        var existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User Subscription not found with id: " + id));
        existing.setUserId(userSubscription.getUserId());
        existing.setSubscriptionId(userSubscription.getSubscriptionId());
        existing.setStatus(userSubscription.getStatus());
        existing.setDateInit(userSubscription.getDateInit());
        existing.setDateEnd(userSubscription.getDateEnd());
        return repository.save(existing);
    }

}
