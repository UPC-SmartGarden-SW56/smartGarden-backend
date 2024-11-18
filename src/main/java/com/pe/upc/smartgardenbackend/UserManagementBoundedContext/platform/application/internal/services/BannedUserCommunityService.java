package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.application.internal.services;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.BannedUserCommunity;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.infrastructure.persistence.jpa.repositories.BannedUserCommunityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannedUserCommunityService {

    private final BannedUserCommunityRepository repository;

    public BannedUserCommunityService(BannedUserCommunityRepository repository) {
        this.repository = repository;
    }

    public BannedUserCommunity createBannedUser(BannedUserCommunity bannedUser) {
        return repository.save(bannedUser);
    }

    public List<BannedUserCommunity> getAllBannedUsers() {
        return repository.findAll();
    }
}
