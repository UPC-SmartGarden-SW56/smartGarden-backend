package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.interfaces.rest.transform;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.domain.model.aggregates.Profile;
import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(entity.getId(), entity.getEmailAddress(), entity.getFullName(), entity.getStreetAddress());
    }

}
