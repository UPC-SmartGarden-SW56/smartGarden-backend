package com.pe.upc.smartgardenbackend.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Order;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.queries.GetAllOrderQuerry;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.queries.GetOrderByIdQuerry;

import java.util.List;
import java.util.Optional;

public interface OrderQueryService {
    Optional<Order> handle(GetOrderByIdQuerry querry);

    List<Order> handle(GetAllOrderQuerry querry);
}
