package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.application.internal.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.BankAccount;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services.BankAccountService;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.infrastucture.persistence.jpa.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository repository;

    public BankAccountServiceImpl(BankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankAccount create(BankAccount bankAccount) {
        return repository.save(bankAccount);
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<BankAccount> findAll() {
        return repository.findAll();
    }

    @Override
    public BankAccount update(Long id, BankAccount bankAccount) {
        var existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bank account not found"));
        existing.setAccountNumber(bankAccount.getAccountNumber());
        existing.setBankName(bankAccount.getBankName());
        existing.setRoutingNumber(bankAccount.getRoutingNumber());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Bank account not found");
        }
        repository.deleteById(id);
    }
}
