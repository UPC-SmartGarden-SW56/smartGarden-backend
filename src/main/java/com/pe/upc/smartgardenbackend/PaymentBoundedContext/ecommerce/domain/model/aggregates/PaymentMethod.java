package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment_methods")
public class PaymentMethod extends AuditableAbstractAggregateRoot<PaymentMethod> {

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
    private String cardHolder;

    @Column(nullable = false, unique = true, length = 16)
    @Getter
    @Setter
    private String cardNumber;

    @Column(nullable = false)
    @Getter
    @Setter
    private String expirationDate;

    @Column(nullable = false, length = 3)
    @Getter
    @Setter
    private String cvv;
}
