package com.pe.upc.smartgardenbackend.profiles.domain.services;

import com.pe.upc.smartgardenbackend.profiles.domain.model.aggregates.Profile;
import com.pe.upc.smartgardenbackend.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
}

