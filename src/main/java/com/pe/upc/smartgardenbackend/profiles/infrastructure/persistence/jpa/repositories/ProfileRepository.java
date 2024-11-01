package com.pe.upc.smartgardenbackend.profiles.infrastructure.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.profiles.domain.model.aggregates.Profile;
import com.pe.upc.smartgardenbackend.profiles.domain.model.valueobjects.EmailAddress;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(EmailAddress emailAddress);
}
