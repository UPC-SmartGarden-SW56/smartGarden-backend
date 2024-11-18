package com.pe.upc.smartgardenbackend.ecommerce.application.internal.commandservices;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Payment;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.CreatePaymentCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.UpdatePaymentCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.commands.DeletePaymentCommand;
import com.pe.upc.smartgardenbackend.ecommerce.domain.services.PaymentCommandService;
import com.pe.upc.smartgardenbackend.ecommerce.infrastucture.persistence.jpa.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {

    private final PaymentRepository paymentRepository;

    public PaymentCommandServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Long handle(CreatePaymentCommand command) {
        var payment = new Payment(command.name(), command.amount(), command.status());
        payment = paymentRepository.save(payment); // Asegúrate de capturar el objeto guardado
        return payment.getId(); // Este ID debe ser generado por JPA
    }


    @Override
    public Optional<Payment> handle(UpdatePaymentCommand command) {
        var payment = paymentRepository.findById(command.id());
        if (payment.isEmpty()) {
            throw new IllegalArgumentException("Payment not found with id: " + command.id());
        }

        var updatedPayment = payment.get();
        updatedPayment.setName(command.name());
        updatedPayment.setAmount(command.amount());
        updatedPayment.setStatus(command.status());

        return Optional.of(paymentRepository.save(updatedPayment));
    }

    @Override
    public void handle(DeletePaymentCommand command) {
        var payment = paymentRepository.findById(command.id());
        if (payment.isEmpty()) {
            throw new IllegalArgumentException("Payment not found with id: " + command.id());
        }
        paymentRepository.delete(payment.get());
    }
}
