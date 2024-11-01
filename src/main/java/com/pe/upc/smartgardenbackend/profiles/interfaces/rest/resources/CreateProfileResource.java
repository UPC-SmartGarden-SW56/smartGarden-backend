package com.pe.upc.smartgardenbackend.profiles.interfaces.rest.resources;

public record CreateProfileResource(String firstName,
                                    String lastName,
                                    String email,
                                    String number,
                                    String city,
                                    String postalCode,
                                    String country) {
}
