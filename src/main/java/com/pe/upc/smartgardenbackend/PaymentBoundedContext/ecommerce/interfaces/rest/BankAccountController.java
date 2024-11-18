package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.interfaces.rest;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.BankAccount;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services.BankAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bank-accounts")
@Tag(name="Bank Account", description = "Bank Account Management Endpoints")
public class BankAccountController {

    private final BankAccountService service;

    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BankAccount> createBankAccount(@RequestBody BankAccount bankAccount) {
        return ResponseEntity.ok(service.create(bankAccount));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankAccount> updateBankAccount(
            @PathVariable Long id,
            @RequestBody BankAccount bankAccount) {
        return ResponseEntity.ok(service.update(id, bankAccount));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
