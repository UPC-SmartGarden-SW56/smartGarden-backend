package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.interfaces.rest.resources;

public record ProfileResource(Long id,
                              String fullName,
                              String email,
                              String streetAddress) {
}
