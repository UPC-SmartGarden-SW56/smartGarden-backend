package com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

@Entity
public class Order extends AuditableAbstractAggregateRoot<Order> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private int status;
}
