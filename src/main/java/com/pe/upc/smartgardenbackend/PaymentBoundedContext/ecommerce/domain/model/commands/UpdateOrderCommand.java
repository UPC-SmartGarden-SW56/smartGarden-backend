package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.commands;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.valueobjects.OrderStatus;

public record UpdateOrderCommand(Long id, int customerId, double amount, OrderStatus status) {}
