package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest.transform;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.commands.UpdatePaymentCommand;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.valueobjects.PaymentStatus;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest.resources.UpdatePaymentResource;

public class UpdatePaymentCommandFromResourceAssembler {

    public static UpdatePaymentCommand toCommandFromResource(Long id, UpdatePaymentResource resource) {
        return new UpdatePaymentCommand(
                id,
                resource.name(),
                resource.amount(),
                PaymentStatus.valueOf(resource.status().toUpperCase())
        );
    }
}
