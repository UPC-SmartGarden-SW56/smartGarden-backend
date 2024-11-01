package com.pe.upc.smartgardenbackend.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Payment;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.queries.GetPaymentByIdQuerry;

import java.util.Optional;

public interface PaymentQueryService {
    Optional<Payment> handle(GetPaymentByIdQuerry querry);
}
