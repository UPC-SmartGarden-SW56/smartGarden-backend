package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.commands;

public record CreateProductCommand(String name, String description, Double price, int stock) {}
