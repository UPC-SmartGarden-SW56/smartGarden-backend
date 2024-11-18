package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.application.internal.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.Subscription;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services.SubscriptionService;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.infrastucture.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository repository;

    public SubscriptionServiceImpl(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscription create(Subscription subscription) {
        return repository.save(subscription);
    }

    @Override
    public Optional<Subscription> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Subscription> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Subscription not found");
        }
        repository.deleteById(id);
    }

    @Override
    public Subscription update(Long id, Subscription subscription) {
        var existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found with id: " + id));
        existing.setName(subscription.getName());
        existing.setTypeUser(subscription.getTypeUser());
        existing.setPrice(subscription.getPrice());
        existing.setDescription(subscription.getDescription());
        existing.setDuration(subscription.getDuration());
        return repository.save(existing);
    }

}
