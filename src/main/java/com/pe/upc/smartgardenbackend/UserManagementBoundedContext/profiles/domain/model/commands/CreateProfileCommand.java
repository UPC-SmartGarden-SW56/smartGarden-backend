package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.domain.model.commands;

public record CreateProfileCommand(String firstName, String lastName,
                                   String email, String number, String city, String postalCode, String country) {
}
