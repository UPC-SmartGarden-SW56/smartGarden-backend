package com.pe.upc.smartgardenbackend.ecommerce.application.internal.commandservices;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Product;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.CreateProductCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.DeleteProductCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.UpdateProductCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.services.ProductCommandService;
import com.pe.upc.smartgardenbackend.ecommerce.infrastucture.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public long handle(CreateProductCommand command) {
        Product product = new Product(
                command.name(),
                command.description(),
                command.price(),
                command.stock()
        );
        productRepository.save(product);
        return product.getId();
    }

    @Override
    public void handle(DeleteProductCommand command) {
        var product = productRepository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + command.id()));
        productRepository.delete(product);
    }

    @Override
    public Product handle(UpdateProductCommand command) {
        var product = productRepository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + command.id()));
        product.setName(command.name());
        product.setDescription(command.description());
        product.setPrice(command.price());
        product.setStock(command.stock());
        return productRepository.save(product);
    }

}
