package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.application.internal.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.PaymentMethod;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services.PaymentMethodService;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.infrastucture.persistence.jpa.repositories.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    private final PaymentMethodRepository repository;

    public PaymentMethodServiceImpl(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentMethod create(PaymentMethod paymentMethod) {
        return repository.save(paymentMethod);
    }

    @Override
    public Optional<PaymentMethod> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PaymentMethod> findAll() {
        return repository.findAll();
    }

    @Override
    public PaymentMethod update(Long id, PaymentMethod paymentMethod) {
        var existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Payment method not found"));
        existing.setCardHolder(paymentMethod.getCardHolder());
        existing.setCardNumber(paymentMethod.getCardNumber());
        existing.setExpirationDate(paymentMethod.getExpirationDate());
        existing.setCvv(paymentMethod.getCvv());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Payment method not found");
        }
        repository.deleteById(id);
    }
}
