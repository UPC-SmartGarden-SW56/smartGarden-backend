package com.pe.upc.smartgardenbackend.course.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;

@Entity
public class Course extends AuditableAbstractAggregateRoot<Course> {
}
