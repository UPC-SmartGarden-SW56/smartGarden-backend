package com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates;
import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.*;

@Entity
public class Payment extends AuditableAbstractAggregateRoot<Payment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double amount; // Monto de la transacción o precio total.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Status status;

    public enum Status {
        PENDING,
        FINISHED,
        DEBT
    }
}
