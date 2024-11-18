package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.Order;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.queries.GetAllOrderQuerry;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.queries.GetOrderByIdQuery;

import java.util.List;
import java.util.Optional;

public interface OrderQueryService {
    Optional<Order> handle(GetOrderByIdQuery query);

    List<Order> handle(GetAllOrderQuerry query);
}
