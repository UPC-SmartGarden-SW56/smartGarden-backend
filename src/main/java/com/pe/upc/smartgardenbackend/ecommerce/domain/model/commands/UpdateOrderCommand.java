package com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands;

public record UpdateOrderCommand(int id,int customerId, double amount,int status) {
}
