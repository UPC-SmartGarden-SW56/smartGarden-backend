package com.pe.upc.smartgardenbackend.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Order;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.CreateOrderCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.DeleteOrderCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.UpdateOrderCommand;

import java.util.Optional;

public interface OrderCommandService {
    Long handle(CreateOrderCommand command);

    void handle(DeleteOrderCommand command);

    Order handle(UpdateOrderCommand command);


}
