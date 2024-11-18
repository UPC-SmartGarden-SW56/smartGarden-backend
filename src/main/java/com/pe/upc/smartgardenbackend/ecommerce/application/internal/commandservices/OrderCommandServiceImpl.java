package com.pe.upc.smartgardenbackend.ecommerce.application.internal.commandservices;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Order;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.CreateOrderCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.DeleteOrderCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.UpdateOrderCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.services.OrderCommandService;
import com.pe.upc.smartgardenbackend.ecommerce.infrastucture.persistence.jpa.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private final OrderRepository orderRepository;

    public OrderCommandServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Long handle(CreateOrderCommand command) {
        var order = new Order();
        order.setCustomerId(command.customerId());
        order.setAmount(command.amount());
        order.setStatus(command.status());
        orderRepository.save(order);
        return order.getId();
    }

    @Override
    public Order handle(UpdateOrderCommand command) {
        var order = orderRepository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + command.id()));
        order.setCustomerId(command.customerId());
        order.setAmount(command.amount());
        order.setStatus(command.status());
        return orderRepository.save(order);
    }

    @Override
    public void handle(DeleteOrderCommand command) {
        var order = orderRepository.findById((long) command.id());
        if (order.isEmpty()) {
            throw new IllegalArgumentException("Order not found with id: " + command.id());
        }
        orderRepository.delete(order.get());
    }
}
