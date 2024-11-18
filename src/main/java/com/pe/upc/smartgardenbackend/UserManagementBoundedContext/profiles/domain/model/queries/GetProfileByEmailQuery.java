package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.domain.model.queries;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {

}
