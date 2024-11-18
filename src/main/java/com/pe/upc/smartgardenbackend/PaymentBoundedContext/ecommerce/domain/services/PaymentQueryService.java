package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.Payment;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.queries.GetAllPaymentsQuery;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.queries.GetPaymentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PaymentQueryService {
    Optional<Payment> handle(GetPaymentByIdQuery query);

    List<Payment> handle(GetAllPaymentsQuery query);

}
