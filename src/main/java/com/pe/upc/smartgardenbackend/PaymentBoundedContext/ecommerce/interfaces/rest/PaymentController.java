package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.application.internal.commandservices.PaymentCommandServiceImpl;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.application.internal.queryservices.PaymentQueryServiceImpl;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.commands.DeletePaymentCommand;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.queries.GetAllPaymentsQuery;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.queries.GetPaymentByIdQuery;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest.resources.CreatePaymentResource;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest.resources.PaymentResource;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest.resources.UpdatePaymentResource;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest.transform.CreatePaymentCommandFromResourceAssembler;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest.transform.PaymentResourceFromEntityAssembler;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest.transform.UpdatePaymentCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/payments")
@Tag(name = "Payments", description = "Payment Management Endpoints")
public class PaymentController {

    private final PaymentCommandServiceImpl paymentCommandService;
    private final PaymentQueryServiceImpl paymentQueryService;

    public PaymentController(PaymentCommandServiceImpl paymentCommandService, PaymentQueryServiceImpl paymentQueryService) {
        this.paymentCommandService = paymentCommandService;
        this.paymentQueryService = paymentQueryService;
    }

    @PostMapping
    public ResponseEntity<PaymentResource> createPayment(@RequestBody CreatePaymentResource resource) {
        var command = CreatePaymentCommandFromResourceAssembler.toCommandFromResource(resource);
        Long paymentId = paymentCommandService.handle(command);
        var payment = paymentQueryService.handle(new GetPaymentByIdQuery(paymentId)).orElseThrow();
        var paymentResource = PaymentResourceFromEntityAssembler.toResourceFromEntity(payment);
        return new ResponseEntity<>(paymentResource, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResource> getPaymentById(@PathVariable Long id) {
        var payment = paymentQueryService.handle(new GetPaymentByIdQuery(id));
        return payment.map(value -> new ResponseEntity<>(PaymentResourceFromEntityAssembler.toResourceFromEntity(value), HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<PaymentResource>> getAllPayments() {
        var payments = paymentQueryService.handle(new GetAllPaymentsQuery());
        var paymentResources = payments.stream()
                .map(PaymentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(paymentResources);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResource> updatePayment(@PathVariable Long id, @RequestBody UpdatePaymentResource resource) {
        var command = UpdatePaymentCommandFromResourceAssembler.toCommandFromResource(id, resource);
        var updatedPayment = paymentCommandService.handle(command);
        return updatedPayment.map(payment -> new ResponseEntity<>(PaymentResourceFromEntityAssembler.toResourceFromEntity(payment), HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentCommandService.handle(new DeletePaymentCommand(id));
        return ResponseEntity.noContent().build();
    }
}
