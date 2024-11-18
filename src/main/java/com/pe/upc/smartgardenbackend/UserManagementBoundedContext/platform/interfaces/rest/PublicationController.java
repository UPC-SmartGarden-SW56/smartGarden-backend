package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.interfaces.rest;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.application.internal.services.PublicationService;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.Publication;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publications")
@Tag(name="Publication", description = "Publication Management Endpoints")
public class PublicationController {

    private final PublicationService service;

    public PublicationController(PublicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Publication> createPublication(@RequestBody Publication publication) {
        return new ResponseEntity<>(service.createPublication(publication), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publication> getPublicationById(@PathVariable Long id) {
        return service.getPublicationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Publication>> getAllPublications() {
        return ResponseEntity.ok(service.getAllPublications());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable Long id) {
        service.deletePublication(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publication> updatePublication(@PathVariable Long id, @RequestBody Publication updatedPublication) {
        return ResponseEntity.ok(service.updatePublication(id, updatedPublication));
    }

}
