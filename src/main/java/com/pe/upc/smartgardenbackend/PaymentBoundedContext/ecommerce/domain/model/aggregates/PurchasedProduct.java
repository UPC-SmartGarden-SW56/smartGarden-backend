package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "purchased_products")
public class PurchasedProduct extends AuditableAbstractAggregateRoot<PurchasedProduct> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private Long userId;

    @Column(nullable = false)
    @Getter
    @Setter
    private Long productId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Getter
    @Setter
    private Date purchaseDate;
}
