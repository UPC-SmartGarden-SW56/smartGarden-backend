package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.infrastructure.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.BannedUserCommunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannedUserCommunityRepository extends JpaRepository<BannedUserCommunity, Long> {
}







