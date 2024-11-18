package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.application.internal.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.PurchasedProduct;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services.PurchasedProductService;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.infrastucture.persistence.jpa.repositories.PurchasedProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchasedProductServiceImpl implements PurchasedProductService {
    private final PurchasedProductRepository repository;

    public PurchasedProductServiceImpl(PurchasedProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchasedProduct create(PurchasedProduct purchasedProduct) {
        return repository.save(purchasedProduct);
    }

    @Override
    public Optional<PurchasedProduct> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PurchasedProduct> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Purchased product not found");
        }
        repository.deleteById(id);
    }


    @Override
    public PurchasedProduct update(Long id, PurchasedProduct purchasedProduct) {
        var existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Purchased Product not found with id: " + id));
        existing.setUserId(purchasedProduct.getUserId());
        existing.setProductId(purchasedProduct.getProductId());
        existing.setPurchaseDate(purchasedProduct.getPurchaseDate());
        return repository.save(existing);
    }
}


