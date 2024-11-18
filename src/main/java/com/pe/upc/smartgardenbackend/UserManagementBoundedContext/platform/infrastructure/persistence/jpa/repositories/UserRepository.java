package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.infrastructure.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
