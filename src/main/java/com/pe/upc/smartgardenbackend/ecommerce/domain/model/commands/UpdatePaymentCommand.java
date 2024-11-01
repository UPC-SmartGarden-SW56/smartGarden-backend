package com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Payment;

public record UpdatePaymentCommand(int id, String name, double amount, Payment.Status status) {
}
