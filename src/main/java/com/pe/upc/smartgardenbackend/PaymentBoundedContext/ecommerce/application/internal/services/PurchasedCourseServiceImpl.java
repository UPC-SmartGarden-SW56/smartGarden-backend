package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.application.internal.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.PurchasedCourse;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services.PurchasedCourseService;
import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.infrastucture.persistence.jpa.repositories.PurchasedCourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchasedCourseServiceImpl implements PurchasedCourseService {
    private final PurchasedCourseRepository repository;

    public PurchasedCourseServiceImpl(PurchasedCourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchasedCourse create(PurchasedCourse purchasedCourse) {
        return repository.save(purchasedCourse);
    }

    @Override
    public Optional<PurchasedCourse> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PurchasedCourse> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Purchased course not found");
        }
        repository.deleteById(id);
    }

    @Override
    public PurchasedCourse update(Long id, PurchasedCourse purchasedCourse) {
        var existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Purchased Course not found with id: " + id));
        existing.setUserId(purchasedCourse.getUserId());
        existing.setCourseId(purchasedCourse.getCourseId());
        existing.setAmount(purchasedCourse.getAmount());
        existing.setPurchaseDate(purchasedCourse.getPurchaseDate());
        existing.setCardNumberMasked(purchasedCourse.getCardNumberMasked());
        return repository.save(existing);
    }
}
