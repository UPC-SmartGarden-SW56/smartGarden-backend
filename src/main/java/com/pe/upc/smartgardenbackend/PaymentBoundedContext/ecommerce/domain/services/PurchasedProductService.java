package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.PurchasedProduct;

import java.util.List;
import java.util.Optional;

public interface PurchasedProductService {
    PurchasedProduct create(PurchasedProduct purchasedProduct);

    Optional<PurchasedProduct> findById(Long id);

    List<PurchasedProduct> findAll();

    void delete(Long id);

    PurchasedProduct update(Long id, PurchasedProduct purchasedProduct);
}
