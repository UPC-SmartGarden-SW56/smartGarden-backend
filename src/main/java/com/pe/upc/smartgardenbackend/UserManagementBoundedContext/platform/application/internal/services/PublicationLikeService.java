package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.application.internal.services;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.PublicationLike;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.infrastructure.persistence.jpa.repositories.PublicationLikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationLikeService {

    private final PublicationLikeRepository repository;

    public PublicationLikeService(PublicationLikeRepository repository) {
        this.repository = repository;
    }

    public PublicationLike addLike(PublicationLike publicationLike) {
        return repository.save(publicationLike);
    }

    public List<PublicationLike> getAllLikes() {
        return repository.findAll();
    }

    public void deleteLike(Long id) {
        repository.deleteById(id);
    }

    public PublicationLike updateLike(Long id, PublicationLike updatedLike) {
        var existingLike = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Like not found with id: " + id));

        existingLike.setDate(updatedLike.getDate());

        return repository.save(existingLike);
    }

}
