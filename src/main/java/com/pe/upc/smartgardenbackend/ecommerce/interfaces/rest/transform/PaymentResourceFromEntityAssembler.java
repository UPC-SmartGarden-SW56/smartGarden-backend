package com.pe.upc.smartgardenbackend.ecommerce.interfaces.rest.transform;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Payment;
import com.pe.upc.smartgardenbackend.ecommerce.interfaces.rest.resources.PaymentResource;

public class PaymentResourceFromEntityAssembler {

    public static PaymentResource toResourceFromEntity(Payment payment) {
        return new PaymentResource(
                payment.getId(),
                payment.getName(),
                payment.getAmount(),
                payment.getStatus().name()
        );
    }
}