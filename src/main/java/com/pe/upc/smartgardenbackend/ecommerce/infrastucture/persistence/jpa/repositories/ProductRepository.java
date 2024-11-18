package com.pe.upc.smartgardenbackend.ecommerce.infrastucture.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
