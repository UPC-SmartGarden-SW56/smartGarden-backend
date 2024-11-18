package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.interfaces.rest;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.application.internal.services.PublicationLikeService;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.PublicationLike;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publication-likes")
@Tag(name="Publication Like", description = "Publication Like Management Endpoints")
public class PublicationLikeController {

    private final PublicationLikeService service;

    public PublicationLikeController(PublicationLikeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PublicationLike> addLike(@RequestBody PublicationLike publicationLike) {
        return new ResponseEntity<>(service.addLike(publicationLike), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PublicationLike>> getAllLikes() {
        return ResponseEntity.ok(service.getAllLikes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long id) {
        service.deleteLike(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicationLike> updateLike(@PathVariable Long id, @RequestBody PublicationLike updatedLike) {
        return ResponseEntity.ok(service.updateLike(id, updatedLike));
    }

}
