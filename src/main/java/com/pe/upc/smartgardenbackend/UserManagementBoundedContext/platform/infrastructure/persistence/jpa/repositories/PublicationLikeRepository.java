package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.infrastructure.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.PublicationLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationLikeRepository extends JpaRepository<PublicationLike, Long> {
}