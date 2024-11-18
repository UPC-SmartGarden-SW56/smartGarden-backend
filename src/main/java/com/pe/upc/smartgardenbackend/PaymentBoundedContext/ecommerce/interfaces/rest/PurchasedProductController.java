package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.PurchasedProduct;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services.PurchasedProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchased-products")
@Tag(name="Purchased Product", description = "Purchased Product Management Endpoints")
public class PurchasedProductController {

    private final PurchasedProductService service;

    public PurchasedProductController(PurchasedProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PurchasedProduct> createPurchasedProduct(@RequestBody PurchasedProduct purchasedProduct) {
        return ResponseEntity.ok(service.create(purchasedProduct));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchasedProduct> getPurchasedProductById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PurchasedProduct>> getAllPurchasedProducts() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchasedProduct(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchasedProduct> updatePurchasedProduct(
            @PathVariable Long id,
            @RequestBody PurchasedProduct purchasedProduct) {
        return ResponseEntity.ok(service.update(id, purchasedProduct));
    }

}
