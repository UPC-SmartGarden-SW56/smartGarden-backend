package com.pe.upc.smartgardenbackend.ecommerce.infrastucture.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
