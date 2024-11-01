package com.pe.upc.smartgardenbackend.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.CreateProductCommand;

public interface ProductCommandService {
    long handle(CreateProductCommand command);
}
