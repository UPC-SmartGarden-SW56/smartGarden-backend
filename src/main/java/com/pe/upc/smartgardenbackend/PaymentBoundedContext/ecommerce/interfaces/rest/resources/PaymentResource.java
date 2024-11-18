package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest.resources;

public record PaymentResource(Long id, String name, double amount, String status) {
}