package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bank_accounts")
public class BankAccount extends AuditableAbstractAggregateRoot<BankAccount> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private Long userId;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String accountNumber;

    @Column(nullable = false)
    @Getter
    @Setter
    private String bankName;

    @Column(nullable = false)
    @Getter
    @Setter
    private String routingNumber;
}
