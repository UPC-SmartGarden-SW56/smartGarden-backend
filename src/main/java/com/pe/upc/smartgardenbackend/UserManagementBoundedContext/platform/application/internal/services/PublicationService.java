package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.application.internal.services;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.Publication;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.infrastructure.persistence.jpa.repositories.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationService {

    private final PublicationRepository repository;

    public PublicationService(PublicationRepository repository) {
        this.repository = repository;
    }

    public Publication createPublication(Publication publication) {
        return repository.save(publication);
    }

    public Optional<Publication> getPublicationById(Long id) {
        return repository.findById(id);
    }

    public List<Publication> getAllPublications() {
        return repository.findAll();
    }

    public void deletePublication(Long id) {
        repository.deleteById(id);
    }

    public Publication updatePublication(Long id, Publication updatedPublication) {
        var existingPublication = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Publication not found with id: " + id));

        existingPublication.setContent(updatedPublication.getContent());
        existingPublication.setImageUrl(updatedPublication.getImageUrl());
        existingPublication.setDate(updatedPublication.getDate());
        existingPublication.setIsPinned(updatedPublication.getIsPinned());
        existingPublication.setNumberLikes(updatedPublication.getNumberLikes());
        existingPublication.setNumberComments(updatedPublication.getNumberComments());

        return repository.save(existingPublication);
    }

}
