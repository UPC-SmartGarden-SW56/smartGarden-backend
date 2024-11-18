package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.application.internal.queryservices;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.Product;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.queries.GetAllProductQuery;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.queries.GetProductByIdQuery;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services.ProductQueryService;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.infrastucture.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> handle(GetAllProductQuery query) {
        // Asegúrate de que el método maneje listas correctamente
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.findById(query.id());
    }

}
