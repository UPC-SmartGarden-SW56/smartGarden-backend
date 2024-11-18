package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.interfaces.rest.transform;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.domain.model.commands.CreateProfileCommand;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(resource.firstName(), resource.lastName(), resource.email(), resource.number(), resource.city(), resource.postalCode(), resource.country());
    }
}
