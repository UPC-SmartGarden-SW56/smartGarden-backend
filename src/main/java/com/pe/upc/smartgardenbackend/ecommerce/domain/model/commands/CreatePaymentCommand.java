package com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.valueobjects.PaymentStatus;

public record CreatePaymentCommand(String name, double amount, PaymentStatus status) {
}
