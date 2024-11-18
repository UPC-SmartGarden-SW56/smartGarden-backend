package com.pe.upc.smartgardenbackend.ecommerce.interfaces.rest;

import com.pe.upc.smartgardenbackend.ecommerce.application.internal.commandservices.OrderCommandServiceImpl;
import com.pe.upc.smartgardenbackend.ecommerce.application.internal.queryservices.OrderQueryServiceImpl;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Order;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.CreateOrderCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.DeleteOrderCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.UpdateOrderCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.queries.GetAllOrderQuerry;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.queries.GetOrderByIdQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@Tag(name = "Orders", description = "Orders Management Endpoints")
public class OrderController {

    private final OrderCommandServiceImpl orderCommandService;
    private final OrderQueryServiceImpl orderQueryService;

    public OrderController(OrderCommandServiceImpl orderCommandService, OrderQueryServiceImpl orderQueryService) {
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
    }

    @PostMapping
    public ResponseEntity<Long> createOrder(@RequestBody CreateOrderCommand command) {
        Long id = orderCommandService.handle(command);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderQueryService.handle(new GetAllOrderQuerry()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.of(orderQueryService.handle(new GetOrderByIdQuery(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderCommandService.handle(new DeleteOrderCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody UpdateOrderCommand command) {
        command = new UpdateOrderCommand(id, command.customerId(), command.amount(), command.status());
        var updatedOrder = orderCommandService.handle(command);
        return ResponseEntity.ok(updatedOrder);
    }

}
