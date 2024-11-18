package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest.transform;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.commands.CreatePaymentCommand;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.valueobjects.PaymentStatus;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest.resources.CreatePaymentResource;

public class CreatePaymentCommandFromResourceAssembler {

    public static CreatePaymentCommand toCommandFromResource(CreatePaymentResource resource) {
        try {
            PaymentStatus status = PaymentStatus.valueOf(resource.status().toUpperCase());
            return new CreatePaymentCommand(resource.name(), resource.amount(), status);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid payment status: " + resource.status());
        }
    }

}
