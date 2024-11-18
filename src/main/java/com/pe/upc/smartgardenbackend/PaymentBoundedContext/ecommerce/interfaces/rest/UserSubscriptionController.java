package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.UserSubscription;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services.UserSubscriptionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-subscriptions")
@Tag(name="User Subscription ", description = "User Subscription Management Endpoints")
public class UserSubscriptionController {

    private final UserSubscriptionService service;

    public UserSubscriptionController(UserSubscriptionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserSubscription> createUserSubscription(@RequestBody UserSubscription userSubscription) {
        return ResponseEntity.ok(service.create(userSubscription));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSubscription> getUserSubscriptionById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserSubscription>> getAllUserSubscriptions() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserSubscription(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserSubscription> updateUserSubscription(
            @PathVariable Long id,
            @RequestBody UserSubscription userSubscription) {
        return ResponseEntity.ok(service.update(id, userSubscription));
    }

}
