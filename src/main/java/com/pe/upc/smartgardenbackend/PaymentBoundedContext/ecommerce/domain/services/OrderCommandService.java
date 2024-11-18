package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.Order;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.commands.CreateOrderCommand;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.commands.DeleteOrderCommand;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.commands.UpdateOrderCommand;

public interface OrderCommandService {
    Long handle(CreateOrderCommand command);

    void handle(DeleteOrderCommand command);

    Order handle(UpdateOrderCommand command);


}
