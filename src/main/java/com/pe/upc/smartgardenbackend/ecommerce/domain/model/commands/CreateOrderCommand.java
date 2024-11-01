package com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands;

public record CreateOrderCommand(int customerId,double amount,int status) {

}
