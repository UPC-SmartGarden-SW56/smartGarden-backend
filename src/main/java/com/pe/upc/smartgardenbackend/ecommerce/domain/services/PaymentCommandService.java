package com.pe.upc.smartgardenbackend.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Payment;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.CreatePaymentCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.DeletePaymentCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.UpdatePaymentCommand;

import java.util.Optional;

public interface PaymentCommandService {
    Long handle(CreatePaymentCommand command);

    Optional<Payment> handle(UpdatePaymentCommand command);

    void handle(DeletePaymentCommand command);
}
