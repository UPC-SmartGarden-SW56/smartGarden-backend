package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.BankAccount;

import java.util.List;
import java.util.Optional;

public interface BankAccountService {
    BankAccount create(BankAccount bankAccount);

    Optional<BankAccount> findById(Long id);

    List<BankAccount> findAll();

    BankAccount update(Long id, BankAccount bankAccount);

    void delete(Long id);
}
