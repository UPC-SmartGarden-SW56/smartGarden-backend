package com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.services;

import com.pe.upc.smartgardenbackend.PaymentBoundedContext.ecommerce.domain.model.aggregates.PurchasedCourse;

import java.util.List;
import java.util.Optional;

public interface PurchasedCourseService {
    PurchasedCourse create(PurchasedCourse purchasedCourse);

    Optional<PurchasedCourse> findById(Long id);

    List<PurchasedCourse> findAll();

    void delete(Long id);

    PurchasedCourse update(Long id, PurchasedCourse purchasedCourse);
}
