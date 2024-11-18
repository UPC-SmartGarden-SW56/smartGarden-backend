package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.valueobjects.OrderStatus;
import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders") // Renombrar a algo que no sea palabra reservada
public class Order extends AuditableAbstractAggregateRoot<Order> {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private int customerId;

    @Getter
    @Setter
    @Column(nullable = false)
    private double amount;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private OrderStatus status;

    public int getCustomerId() {
        return customerId;
    }
}
