package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.infrastucture.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    // Custom queries if needed
}
