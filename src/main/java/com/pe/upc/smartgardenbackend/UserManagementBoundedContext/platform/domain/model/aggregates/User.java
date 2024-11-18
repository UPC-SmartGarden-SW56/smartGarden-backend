package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.valueobjects.UserType;
import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends AuditableAbstractAggregateRoot<User> {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType type;

    private String experience;

    @Column(name = "time_to_dedicate")
    private String timeToDedicate;

    @Column(name = "target_age_range")
    private String targetAgeRange;
}
