package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.application.internal.services;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.Expert;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.infrastructure.persistence.jpa.repositories.ExpertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertService {
    private final ExpertRepository expertRepository;

    public ExpertService(ExpertRepository expertRepository) {
        this.expertRepository = expertRepository;
    }

    public Expert createExpert(Expert expert) {
        return expertRepository.save(expert);
    }

    public List<Expert> getAllExperts() {
        return expertRepository.findAll();
    }
}
