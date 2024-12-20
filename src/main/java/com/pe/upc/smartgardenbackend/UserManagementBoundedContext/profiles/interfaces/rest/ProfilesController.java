package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.interfaces.rest;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.domain.model.queries.GetAllProfilesQuery;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.domain.model.queries.GetProfileByIdQuery;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.domain.services.ProfileCommandService;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.domain.services.ProfileQueryService;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.interfaces.rest.resources.CreateProfileResource;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.interfaces.rest.resources.ProfileResource;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Profiles", description = "Profile Management Endpoints")
public class ProfilesController {
    private final ProfileQueryService profileQueryService;
    private final ProfileCommandService profileCommandService;

    public ProfilesController(ProfileQueryService profileQueryService, ProfileCommandService profileCommandService) {
        this.profileQueryService = profileQueryService;
        this.profileCommandService = profileCommandService;
    }

    @Operation(
            summary = "Create a profile",
            description = "Creates a profile with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Profile created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreateProfileResource resource) {
        var createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var profile = profileCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return ResponseEntity.badRequest().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get a profile by ID",
            description = "Gets a profile by the provided ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profile found"),
            @ApiResponse(responseCode = "404", description = "Profile not found")
    })
    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable Long profileId) {
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) return ResponseEntity.notFound().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }

    @GetMapping
    public ResponseEntity<List<ProfileResource>> getAllProfiles() {
        var getAllProfilesQuery = new GetAllProfilesQuery();
        var profiles = profileQueryService.handle(getAllProfilesQuery);
        var profileResources = profiles.stream().map(ProfileResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(profileResources);
    }

}
