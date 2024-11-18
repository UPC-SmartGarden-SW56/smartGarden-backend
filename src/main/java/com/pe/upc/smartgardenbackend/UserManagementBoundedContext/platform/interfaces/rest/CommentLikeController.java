package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.interfaces.rest;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.application.internal.services.CommentLikeService;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.CommentLike;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment-likes")
@Tag(name="Comment Like", description = "Comment Like Management Endpoints")
public class CommentLikeController {

    private final CommentLikeService service;

    public CommentLikeController(CommentLikeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CommentLike> addLike(@RequestBody CommentLike commentLike) {
        return new ResponseEntity<>(service.addLike(commentLike), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CommentLike>> getAllLikes() {
        return ResponseEntity.ok(service.getAllLikes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long id) {
        service.deleteLike(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentLike> updateLike(@PathVariable Long id, @RequestBody CommentLike updatedLike) {
        return ResponseEntity.ok(service.updateLike(id, updatedLike));
    }

}
