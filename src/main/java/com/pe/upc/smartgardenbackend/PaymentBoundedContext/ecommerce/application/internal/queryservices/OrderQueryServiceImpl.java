package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.application.internal.queryservices;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.Order;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.queries.GetAllOrderQuerry;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.queries.GetOrderByIdQuery;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services.OrderQueryService;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.infrastucture.persistence.jpa.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {

    private final OrderRepository orderRepository;

    public OrderQueryServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> handle(GetOrderByIdQuery query) {
        return orderRepository.findById(query.id());
    }

    @Override
    public List<Order> handle(GetAllOrderQuerry query) {
        return orderRepository.findAll();
    }
}
