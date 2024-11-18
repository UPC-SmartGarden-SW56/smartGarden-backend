package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.application.internal.services;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.CommentLike;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.infrastructure.persistence.jpa.repositories.CommentLikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentLikeService {

    private final CommentLikeRepository repository;

    public CommentLikeService(CommentLikeRepository repository) {
        this.repository = repository;
    }

    public CommentLike addLike(CommentLike commentLike) {
        return repository.save(commentLike);
    }

    public List<CommentLike> getAllLikes() {
        return repository.findAll();
    }

    public void deleteLike(Long id) {
        repository.deleteById(id);
    }

    public CommentLike updateLike(Long id, CommentLike updatedLike) {
        var existingLike = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comment like not found with id: " + id));

        existingLike.setDate(updatedLike.getDate());

        return repository.save(existingLike);
    }

}
