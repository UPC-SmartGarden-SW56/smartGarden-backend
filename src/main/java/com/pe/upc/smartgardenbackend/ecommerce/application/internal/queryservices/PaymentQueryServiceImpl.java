package com.pe.upc.smartgardenbackend.ecommerce.application.internal.queryservices;

import com.pe.upc.smartgardenbackend.ecommerce.domain.model.aggregates.Payment;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.queries.GetAllPaymentsQuery;
import com.pe.upc.smartgardenbackend.ecommerce.domain.model.queries.GetPaymentByIdQuery;
import com.pe.upc.smartgardenbackend.ecommerce.domain.services.PaymentQueryService;
import com.pe.upc.smartgardenbackend.ecommerce.infrastucture.persistence.jpa.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {

    private final PaymentRepository paymentRepository;

    public PaymentQueryServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> handle(GetPaymentByIdQuery query) {
        return paymentRepository.findById(query.id());
    }

    @Override
    public List<Payment> handle(GetAllPaymentsQuery query) {
        return paymentRepository.findAll();
    }


}
