package com.pe.upc.smartgardenbackend.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Product;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.queries.GetAllProductQuerry;

import java.util.Optional;

public interface ProductQueryService {
    Optional<Product> handle(GetAllProductQuerry querry);
}
