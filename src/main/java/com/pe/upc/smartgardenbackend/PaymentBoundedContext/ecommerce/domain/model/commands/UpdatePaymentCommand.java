package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.commands;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.valueobjects.PaymentStatus;

public record UpdatePaymentCommand(Long id, String name, double amount, PaymentStatus status) {
}
