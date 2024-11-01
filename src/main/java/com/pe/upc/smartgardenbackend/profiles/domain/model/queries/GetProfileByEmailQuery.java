package com.pe.upc.smartgardenbackend.profiles.domain.model.queries;

import com.pe.upc.smartgardenbackend.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {

}
