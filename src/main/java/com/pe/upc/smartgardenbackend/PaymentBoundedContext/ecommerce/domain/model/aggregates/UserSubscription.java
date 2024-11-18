package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user_subscriptions")
public class UserSubscription extends AuditableAbstractAggregateRoot<UserSubscription> {
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
    private Long subscriptionId;

    @Column(nullable = false)
    @Getter
    @Setter
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Getter
    @Setter
    private Date dateInit;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Getter
    @Setter
    private Date dateEnd;
}
