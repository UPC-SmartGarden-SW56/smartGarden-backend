package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "purchased_courses")
public class PurchasedCourse extends AuditableAbstractAggregateRoot<PurchasedCourse> {
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
    private Long courseId;

    @Column(nullable = false)
    @Getter
    @Setter
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    @Column(nullable = false)
    private Date purchaseDate;

    @Column(nullable = false, length = 19)
    @Getter
    @Setter
    private String cardNumberMasked;
}
