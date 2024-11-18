package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.commands;

public record UpdateProductCommand(Long id, String name, String description, Double price, int stock) {}
