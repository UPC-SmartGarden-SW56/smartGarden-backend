package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "subscriptions")
public class Subscription extends AuditableAbstractAggregateRoot<Subscription> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(nullable = false)
    @Getter
    @Setter
    private String typeUser;

    @Column(nullable = false)
    @Getter
    @Setter
    private double price;

    @Column(nullable = false)
    @Getter
    @Setter
    private String description;

    @Column(nullable = false)
    @Getter
    @Setter
    private String duration; // Duration could be a string or an enum
}
