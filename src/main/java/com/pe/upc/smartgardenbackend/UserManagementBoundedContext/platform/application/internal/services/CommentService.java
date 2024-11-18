package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.application.internal.services;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.Comment;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.infrastructure.persistence.jpa.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public Comment addComment(Comment comment) {
        return repository.save(comment);
    }

    public Optional<Comment> getCommentById(Long id) {
        return repository.findById(id);
    }

    public List<Comment> getAllComments() {
        return repository.findAll();
    }

    public void deleteComment(Long id) {
        repository.deleteById(id);
    }

    public Comment updateComment(Long id, Comment updatedComment) {
        var existingComment = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found with id: " + id));

        existingComment.setContent(updatedComment.getContent());
        existingComment.setImageUrl(updatedComment.getImageUrl());
        existingComment.setDate(updatedComment.getDate());
        existingComment.setNumberLikes(updatedComment.getNumberLikes());
        existingComment.setNumberResponses(updatedComment.getNumberResponses());

        return repository.save(existingComment);
    }

}
