package com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.valueobjects.OrderStatus;

public record CreateOrderCommand(int customerId, double amount, OrderStatus status) {}
