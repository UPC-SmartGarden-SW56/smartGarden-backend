package com.pe.upc.smartgardenbackend.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Payment;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.UpdatePaymentCommand;

import java.util.Optional;

public interface PaymentCommandService {
    Optional<Payment> handle(UpdatePaymentCommand command);
}
