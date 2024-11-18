package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.PurchasedCourse;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services.PurchasedCourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchased-courses")
@Tag(name="Purchased Course", description = "Purchased Course Management Endpoints")
public class PurchasedCourseController {

    private final PurchasedCourseService service;

    public PurchasedCourseController(PurchasedCourseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PurchasedCourse> createPurchasedCourse(@RequestBody PurchasedCourse purchasedCourse) {
        return ResponseEntity.ok(service.create(purchasedCourse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchasedCourse> getPurchasedCourseById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PurchasedCourse>> getAllPurchasedCourses() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchasedCourse(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchasedCourse> updatePurchasedCourse(
            @PathVariable Long id,
            @RequestBody PurchasedCourse purchasedCourse) {
        return ResponseEntity.ok(service.update(id, purchasedCourse));
    }

}
