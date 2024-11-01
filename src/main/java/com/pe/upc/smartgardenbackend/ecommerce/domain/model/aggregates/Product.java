package com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates;
import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Product extends AuditableAbstractAggregateRoot<Product>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private int stock;
}
