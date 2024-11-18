package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.infrastructure.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertRepository extends JpaRepository<Expert, Long> {
}
