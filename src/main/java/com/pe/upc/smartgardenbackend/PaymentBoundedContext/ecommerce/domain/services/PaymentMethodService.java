package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.PaymentMethod;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodService {
    PaymentMethod create(PaymentMethod paymentMethod);

    Optional<PaymentMethod> findById(Long id);

    List<PaymentMethod> findAll();

    PaymentMethod update(Long id, PaymentMethod paymentMethod);

    void delete(Long id);
}
