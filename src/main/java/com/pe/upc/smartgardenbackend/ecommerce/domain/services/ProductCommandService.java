package com.pe.upc.smartgardenbackend.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Product;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.CreateProductCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.DeleteProductCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.UpdateProductCommand;

public interface ProductCommandService {
    long handle(CreateProductCommand command);
    void handle(DeleteProductCommand command);
    Product handle(UpdateProductCommand command);
}
