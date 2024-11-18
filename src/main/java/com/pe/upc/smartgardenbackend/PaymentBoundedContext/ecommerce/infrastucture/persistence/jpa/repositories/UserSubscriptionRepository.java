package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.infrastucture.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {
    // Custom queries if needed
}
