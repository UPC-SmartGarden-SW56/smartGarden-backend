package com.pe.upc.smartgardenbackend.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Product;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.queries.GetAllProductQuery;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.queries.GetProductByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProductQueryService {
    List<Product> handle(GetAllProductQuery query);

    Optional<Product> handle(GetProductByIdQuery query);

}