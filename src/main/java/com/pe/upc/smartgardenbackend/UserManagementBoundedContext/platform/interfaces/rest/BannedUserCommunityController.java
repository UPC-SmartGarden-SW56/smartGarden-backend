package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.interfaces.rest;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.application.internal.services.BannedUserCommunityService;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates.BannedUserCommunity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/banned-users")
@Tag(name="Banned User Community", description = "Banned User Community Management Endpoints")
public class BannedUserCommunityController {

    private final BannedUserCommunityService service;

    public BannedUserCommunityController(BannedUserCommunityService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BannedUserCommunity> createBannedUser(@RequestBody BannedUserCommunity bannedUser) {
        return new ResponseEntity<>(service.createBannedUser(bannedUser), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BannedUserCommunity>> getAllBannedUsers() {
        return ResponseEntity.ok(service.getAllBannedUsers());
    }
}
