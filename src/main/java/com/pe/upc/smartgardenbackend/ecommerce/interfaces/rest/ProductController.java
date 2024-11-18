package com.pe.upc.smartgardenbackend.ecommerce.interfaces.rest;

import com.pe.upc.smartgardenbackend.ecommerce.application.internal.commandservices.ProductCommandServiceImpl;
import com.pe.upc.smartgardenbackend.ecommerce.application.internal.queryservices.ProductQueryServiceImpl;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Product;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.CreateProductCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.DeleteProductCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.UpdateProductCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.queries.GetAllProductQuery;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.queries.GetProductByIdQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Products", description = "Product Management Endpoints")
public class ProductController {

    private final ProductCommandServiceImpl productCommandService;
    private final ProductQueryServiceImpl productQueryService;

    public ProductController(ProductCommandServiceImpl productCommandService, ProductQueryServiceImpl productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody CreateProductCommand command) {
        Long id = productCommandService.handle(command);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productQueryService.handle(new GetAllProductQuery()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.of(productQueryService.handle(new GetProductByIdQuery(id)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productCommandService.handle(new DeleteProductCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody UpdateProductCommand command) {
        command = new UpdateProductCommand(id, command.name(), command.description(), command.price(), command.stock());
        var updatedProduct = productCommandService.handle(command);
        return ResponseEntity.ok(updatedProduct);
    }

}
